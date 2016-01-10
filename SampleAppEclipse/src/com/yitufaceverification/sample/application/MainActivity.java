package com.yitufaceverification.sample.application;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.json.JSONException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment;
import com.yitutech.face.databaseimagesdk.fanpaizhao.OnDatabaseImageCapturedEventListener;
import com.yitutech.face.utilities.algorithms.DetectedRect;
import com.yitutech.face.utilities.datatype.AccessInfo;
import com.yitutech.face.utilities.datatype.DatabaseImageType;
import com.yitutech.face.utilities.datatype.UserInfo;
import com.yitutech.face.utilities.utils.LogUtil;
import com.yitutech.face.videorecordersdk.YituServiceConfigSDK;
import com.yitutech.face.yitufaceverificationsdk.datatype.DetectionFrame;
import com.yitutech.face.yitulivenessdetectionsdk.face_image_verification.FaceImageVerificationClientIf;
import com.yitutech.face.yitulivenessdetectionsdk.face_image_verification.FaceImageVerificationParameter;
import com.yitutech.face.yitulivenessdetectionsdk.face_image_verification.FaceImageVerificationResult;
import com.yitutech.face.yitulivenessdetectionsdk.liveness_detection.VerificationResultListener;
import com.yitutech.face.yitulivenessdetectionsdk.sdk.OnInitializeFinishEventListener;

public class MainActivity extends Activity implements
		VerificationResultListener, OnInitializeFinishEventListener,
		OnDatabaseImageCapturedEventListener {

	private static final String TAG = MainActivity.class.getSimpleName();
	// 客户信息
	private final AccessInfo accessInfo = new AccessInfo(" ",
			"28b7e5324f155784963fbef05e2dd1ad");
	// 用户信息
	private final UserInfo mUserInfo = new UserInfo("test_uid_sample",
			accessInfo);
	// 是否启动了调试模式
	private boolean mDebugIsOn = false;
	private LivenessDetectionSDK_wrapper mLivenessDetectionSDK;
	private CaptureDatabaseImageFragment_wrapper mUserRegistrationCameraFragment;
	private LivenessDetectionFragment_wrapper mLivenessDetectionFragment;
	private LinearLayout mMainLayout;

	// 是否立即启动比对
	private static boolean startImmediate = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String hostPrefix = "https://staging.yitutech.com/";
		try {
			YituServiceConfigSDK
					.setServiceURL(
							YituServiceConfigSDK.ServiceType.YITU_PAIR_VERIFICATION,
							hostPrefix
									+ "/face/v1/application/identity_verification/face_verification");
			YituServiceConfigSDK
					.setServiceURL(
							YituServiceConfigSDK.ServiceType.YITU_UPLOAD_DATABASE_IMAGE,
							hostPrefix
									+ "/face/v1/application/identity_verification/user/upload_database_image");
			YituServiceConfigSDK
					.setServiceURL(
							YituServiceConfigSDK.ServiceType.YITU_CHECK_DATABASE_IMAGE,
							hostPrefix
									+ "/face/v1/application/identity_verification/user");
			YituServiceConfigSDK
					.setServiceURL(
							YituServiceConfigSDK.ServiceType.YITU_USER_MARK_UPLOAD_SERVICE,
							hostPrefix + "/face/v1/service/user_usage_mark");
			YituServiceConfigSDK
					.setServiceURL(
							YituServiceConfigSDK.ServiceType.YITU_USER_MARK_UPLOAD_SERVICE,
							hostPrefix
									+ "/face/v1/application/upload_user_status");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 仅活体检测
		Button mLivenessDetectionOnlyButton = (Button) findViewById(R.id.liveness_detection_only_button);
		mLivenessDetectionOnlyButton
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						livenessDetection(null, null);
					}
				});

		// 调试模式切换按钮
		ToggleButton mDebugToggleButton = (ToggleButton) findViewById(R.id.debug_toggle_button);
		mDebugToggleButton
				.setOnCheckedChangeListener(mDebugToggleButtonListener);

		mMainLayout = (LinearLayout) findViewById(R.id.choose_button_layout);

	}

	private final CompoundButton.OnCheckedChangeListener mDebugToggleButtonListener = new CompoundButton.OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			if (isChecked) {
				mDebugIsOn = true;
			} else {
				mDebugIsOn = false;
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		return super.onOptionsItemSelected(item);
	}

	/**
	 * 活体检测
	 * 
	 * @param userInfo
	 *            用户信息，如果是null，那么不启动身份验证
	 * @param faceImageVerificationClient
	 *            不过是null，那么就用默认的身份验证client
	 */
	private void livenessDetection(UserInfo userInfo,
			FaceImageVerificationClientIf faceImageVerificationClient) {
		findViewById(R.id.livenessDetectionFragment)
				.setVisibility(View.VISIBLE);
		findViewById(R.id.choose_button_layout).setVisibility(View.INVISIBLE);

		mLivenessDetectionSDK = new LivenessDetectionSDK_wrapper();
		// onVerificationSuccess和onVerificationFail将能收到回调结果
		try {
			mLivenessDetectionSDK.setVerificationResultListener(this);
			// 设置调试模式
			mLivenessDetectionSDK.setDebugMode(mDebugIsOn);

			if (faceImageVerificationClient != null) {
				// 允许使用自定义比对逻辑, 一般不需要
				mLivenessDetectionSDK
						.setFaceImageVerificationClient(faceImageVerificationClient);
			}

			if (userInfo != null) {
				// 如果需要仅仅判断整个活体检测过程中是否是一个人, 即利用依图Saas服务做交叉比对, 需要设置类型为 4
				mLivenessDetectionSDK.setVerifyType(3);
				// 最后一个参数表示使用本Activity的onFinish onFail接收SDK启动是否成功的结果
				mLivenessDetectionSDK.init(MainActivity.this, userInfo, this,
						startImmediate);
			} else {
				// 禁用比对, 仅作活体检测
				mLivenessDetectionSDK.setVerifyType(0);
				// 第二个参数mUserInfo实际上仅会被用到其中的accessInfo
				mLivenessDetectionSDK.init(MainActivity.this, mUserInfo, this,
						startImmediate);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**************************************** 活体检测模块回调函数 ***************************************/

	// 实现了VerificationResultListener接口, 用于获取比对结果
	@Override
	public void onVerificationSuccess(float verificationScore,
			final String scoreExplanation, List<byte[]> capturedImageJPGData,
			String sessionId, String var5) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				new AlertDialog.Builder(MainActivity.this)
						.setTitle("检测成功(" + scoreExplanation + ")")
						.setPositiveButton("知道了!",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// 移除活体检测界面
										try {
											LivenessDetectionSDK_wrapper
													.recycleFragment(
															mLivenessDetectionFragment,
															MainActivity.this);
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										findViewById(
												R.id.livenessDetectionFragment)
												.setVisibility(View.INVISIBLE);
										findViewById(R.id.choose_button_layout)
												.setVisibility(View.VISIBLE);
									}
								}).setCancelable(false).show();
			}
		});
		try {
			// 保存人脸正脸图, 目前的实现仅提供灰度人脸图
			// 保证数量>=1 且第一张是正脸图
			byte[] image = capturedImageJPGData.get(0);
			String outputFileName = saveJpegToSdcard(image);
			Log.i(TAG + "------------>", "save face to " + outputFileName);
		} catch (Exception e) {
			Log.e(TAG, "save face failed ", e);
		}
	}

	// 实现了VerificationResultListener接口, 用于获取比对结果
	@Override
	public void onVerificationFail(VerificationFailReason failReason,
			final float verificationScore, final String scoreExplanation,
			List<byte[]> capturedImageJPGData, String sessionId) {
		final String hintString = failReason.name();

		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				new AlertDialog.Builder(MainActivity.this)
						.setTitle("检测失败")
						.setMessage(
								hintString + "\n身份验证分数:" + verificationScore)
						.setPositiveButton("知道了!",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// 移除活体检测界面
										try {
											LivenessDetectionSDK_wrapper
													.recycleFragment(
															mLivenessDetectionFragment,
															MainActivity.this);
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										findViewById(
												R.id.livenessDetectionFragment)
												.setVisibility(View.INVISIBLE);
										findViewById(R.id.choose_button_layout)
												.setVisibility(View.VISIBLE);
									}
								}).setCancelable(false).show();
			}
		});
		try {
			// 保存人脸正脸图, 目前的实现仅提供灰度人脸图
			// 保证数量>=1 且第一张是正脸图
			byte[] image = capturedImageJPGData.get(0);
			String outputFileName = saveJpegToSdcard(image);
			Log.i(TAG, "save face to " + outputFileName);
		} catch (Exception e) {
			Log.e(TAG, "save face failed ", e);
		}
	}

	// 实现了OnInitializeFinishEventListener接口, 活体检测界面准备失败
	@Override
	public void onFail(Exception e) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				new AlertDialog.Builder(MainActivity.this)
						.setTitle("抱歉，启动活体检测失败")
						.setMessage("请检查网络，返回并重新尝试")
						.setPositiveButton("知道了!",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										MainActivity.this.finish();
									}
								}).create().show();
			}
		});
	}

	// 实现了OnInitializeFinishEventListener接口, 活体检测界面准备完成
	@Override
	public void onFinish() {
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		try {
			mLivenessDetectionFragment = MainActivity.this.mLivenessDetectionSDK
					.getLivenessDetectionFragment(MainActivity.this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ft.add(R.id.livenessDetectionFragment,
				(Fragment) LivenessDetectionFragment_wrapper.mInstance,
				LivenessDetectionFragment_wrapper.TAG);
		ft.commitAllowingStateLoss();

		if (!startImmediate) {
			AlertDialog dialog = new AlertDialog.Builder(this)
					.setTitle("活体检测")
					.setMessage("请在光照良好的室内进行比对")
					.setPositiveButton("开始",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// start()应在fragment.onResume()之后被调用
									try {
										mLivenessDetectionSDK.start();
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}).create();
			dialog.show();
		}

	}

	/********************************** 活体检测模块回调函数结束 ************************************/

	/*********************************** 登记照模块示例 ************************************/

	private void attachUserImageRegistractionFragment() {

		mMainLayout.setVisibility(View.GONE);
		FragmentManager mFragmentManager = getFragmentManager();
		CaptureDatabaseImageFragment_wrapper userImageRegisterFragment = (CaptureDatabaseImageFragment_wrapper) mFragmentManager
				.findFragmentByTag(CaptureDatabaseImageFragment.TAG);

		if (userImageRegisterFragment == null) {

			// 第三个参数设为本Activity, 因此本类的OnDatabaseImageCaptured将会接收回调;
			// 最后一个参数表示拍摄的是身份证正面还是背面
			userImageRegisterFragment = CaptureDatabaseImageFragment_wrapper
					.newInstance(
							this,
							mUserInfo.getAccessInfo(),
							this,
							CaptureDatabaseImageFragment.CAPTURE_MODE_IDCARD_FRONT);

			Log.i(TAG, "fragment is not added to activity, create new instance");
			FragmentTransaction ft = mFragmentManager.beginTransaction();
			findViewById(R.id.userImageRegisterFragment).setVisibility(
					View.VISIBLE);
			ft.add(R.id.userImageRegisterFragment, userImageRegisterFragment,
					CaptureDatabaseImageFragment.TAG);
			ft.commit();
		} else {
			if (userImageRegisterFragment.isAdded()) {
				LogUtil.i(TAG, "user image register fragment already attached");
			}
		}

		mUserRegistrationCameraFragment = userImageRegisterFragment;
	}

	// 实现了OnDatabaseImageCapturedEventListener接口,
	// 被CaptureDatabaseImageFragment回调
	@Override
	public void OnDatabaseImageCaptured(byte[] data, DetectedRect rect) {
		Toast.makeText(MainActivity.this, "获取拍摄图片", Toast.LENGTH_SHORT).show();

		FragmentManager mFragmentManager = getFragmentManager();
		FragmentTransaction ft = mFragmentManager.beginTransaction();
		ft.remove(mUserRegistrationCameraFragment);
		ft.commitAllowingStateLoss();
		findViewById(R.id.livenessDetectionFragment).setVisibility(
				View.INVISIBLE);
		findViewById(R.id.choose_button_layout).setVisibility(View.VISIBLE);
		if (rect != null) {
			// 如果检测到了人脸
			Log.i(TAG, "人脸框:" + rect.rect.toString());
			uploadDataBaseImage(mUserInfo, DatabaseImageType.证件照翻拍, data);
		}
	}

	// 上传登记照样例代码
	private void uploadDataBaseImage(final UserInfo userInfo,
			final Integer imageType, final byte[] image) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					DatabaseImageSDK_wrapper yituUploadUserImageSDK = new DatabaseImageSDK_wrapper(
							MainActivity.this);

					// 上传用户登记照
					yituUploadUserImageSDK.uploadDatabaseImage(userInfo,
							imageType, image);
					// 检查用户登记照是否存在
					final List<Integer> currentImageTypes = yituUploadUserImageSDK
							.checkDatabaseImageStatus(mUserInfo);
					Log.i("uploadDataBaseImage", "CheckUserImageUploadResult: "
							+ currentImageTypes);
					final boolean registerSuccess = currentImageTypes
							.contains(imageType);

					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							mMainLayout.setVisibility(View.VISIBLE);
							new AlertDialog.Builder(MainActivity.this)
									.setTitle(
											"上传"
													+ (registerSuccess ? "成功"
															: "失败"))
									.setPositiveButton(
											"知道了!",
											new DialogInterface.OnClickListener() {
												@Override
												public void onClick(
														DialogInterface dialog,
														int which) {
												}
											}).setCancelable(false).show();
						}
					});
				} catch (TimeoutException e) {
					Log.e(TAG, "timeout : ", e);
				} catch (IOException e) {
					Log.e(TAG, "io error : ", e);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();
	}

	/*********************************** 登记照模块示例结束 ************************************/

	// 自定义比对客户端, FacePairVerifierClient对任何比对返回98.76作为分数
	// 本接口普通客户不需要关注和实现
	private class FacePairVerifierClient implements
			FaceImageVerificationClientIf {

		@Override
		public FaceImageVerificationResult getVerificationResult()
				throws IOException, JSONException {
			Log.i(TAG, "getVerificationResult");
			// 返回身份验证结果
			FaceImageVerificationResult result = new FaceImageVerificationResult();
			result.result = 0;
			result.similarity = 98.76;
			return result;
		}

		@Override
		public String getSessionId() {
			return "sampleapp";
		}

		@Override
		public void initClient(String startSessionURL, String verifyServiceURL,
				String resultServiceURL, AccessInfo accessInfo) {
			// 初始化身份验证Client
			Log.i(TAG, "initClient");
		}

		@Override
		public void sendImageToVerify(String sessionId,
				List<DetectionFrame> actionImages) throws JSONException,
				IOException, NullPointerException {
			// 发送身份验证请求
			Log.i(TAG, "sendImageToVerify");
		}

		@Override
		public String startSession(String userId,
				FaceImageVerificationParameter pairVerificationConfig)
				throws JSONException, IOException, NullPointerException {
			// 启动身份验证会话，返回会话id
			Log.i(TAG, "startSession");
			return "session_id";
		}

	}

	private String saveJpegToSdcard(byte[] image) throws IOException {
		String outputFileName = "/sdcard/detect_face_"
				+ System.currentTimeMillis() + ".jpg";
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(new File(outputFileName)));
		bos.write(image);
		bos.flush();
		bos.close();
		return outputFileName;
	}

}
