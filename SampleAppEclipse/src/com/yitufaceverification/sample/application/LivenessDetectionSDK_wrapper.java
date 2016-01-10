package com.yitufaceverification.sample.application;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.util.Log;

import com.yitutech.face.utilities.datatype.UserInfo;
import com.yitutech.face.yitufaceverificationsdk.fragment.LivenessDetectionFragment;
import com.yitutech.face.yitulivenessdetectionsdk.face_image_verification.FaceImageVerificationClientIf;
import com.yitutech.face.yitulivenessdetectionsdk.face_image_verification.FaceImageVerificationParameter;
import com.yitutech.face.yitulivenessdetectionsdk.liveness_detection.VerificationResultListener;
import com.yitutech.face.yitulivenessdetectionsdk.sdk.OnInitializeFinishEventListener;

public class LivenessDetectionSDK_wrapper {

	private static Object mInstance;

	public LivenessDetectionSDK_wrapper() {
		Object item = null;
		try {
			Class classType = Class
					.forName("com.yitutech.face.yitulivenessdetectionsdk.sdk.LivenessDetectionSDK");
			Constructor<?> cons[] = classType.getConstructors();
			item = cons[0].newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		this.mInstance = item;
	}

	public static void setUpHTTPS(Activity param0) throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.yitulivenessdetectionsdk.sdk.LivenessDetectionSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("setUpHTTPS",
					new Class[] { Activity.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "setUpHTTPS is null");
			_setAppInfo.invoke(cls, new Object[] { param0 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void init(Activity param0, UserInfo param1,
			OnInitializeFinishEventListener param2, boolean param3)
			throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.yitulivenessdetectionsdk.sdk.LivenessDetectionSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("init", new Class[] {
					Activity.class, UserInfo.class,
					OnInitializeFinishEventListener.class, boolean.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "init is null");
			_setAppInfo.invoke(mInstance, new Object[] { param0, param1,
					param2, param3 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void start() throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.yitulivenessdetectionsdk.sdk.LivenessDetectionSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("start", new Class[0]);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "start is null");
			_setAppInfo.invoke(mInstance, null);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void setFaceImageVerificationClient(
			FaceImageVerificationClientIf param0) throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.yitulivenessdetectionsdk.sdk.LivenessDetectionSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod(
					"setFaceImageVerificationClient",
					new Class[] { FaceImageVerificationClientIf.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "setFaceImageVerificationClient is null");
			_setAppInfo.invoke(mInstance, new Object[] { param0 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void setFaceImageVerificationParameter(
			FaceImageVerificationParameter param0) throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.yitulivenessdetectionsdk.sdk.LivenessDetectionSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod(
					"setFaceImageVerificationParameter",
					new Class[] { FaceImageVerificationParameter.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "setFaceImageVerificationParameter is null");
			_setAppInfo.invoke(mInstance, new Object[] { param0 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void setVerificationResultListener(VerificationResultListener param0)
			throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.yitulivenessdetectionsdk.sdk.LivenessDetectionSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod(
					"setVerificationResultListener",
					new Class[] { VerificationResultListener.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "setVerificationResultListener is null");
			_setAppInfo.invoke(mInstance, new Object[] { param0 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public LivenessDetectionFragment_wrapper getLivenessDetectionFragment(
			Activity param0) throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.yitulivenessdetectionsdk.sdk.LivenessDetectionSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("getLivenessDetectionFragment",
					new Class[] { Activity.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "getLivenessDetectionFragment is null");
			Object ob = _setAppInfo.invoke(mInstance, new Object[] { param0 });
			LivenessDetectionFragment_wrapper.mInstance = ob;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void attachFragmentToActivity(LivenessDetectionFragment param0,
			Activity param1) throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.yitulivenessdetectionsdk.sdk.LivenessDetectionSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("attachFragmentToActivity",
					new Class[] { LivenessDetectionFragment.class,
							Activity.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "attachFragmentToActivity is null");
			_setAppInfo.invoke(mInstance, new Object[] { param0, param1 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public static void recycleFragment(
			LivenessDetectionFragment_wrapper param0, Activity param1)
			throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.yitulivenessdetectionsdk.sdk.LivenessDetectionSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("recycleFragment", new Class[] {
					LivenessDetectionFragment.class, Activity.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "recycleFragment is null");
			_setAppInfo.invoke(cls, new Object[] {
					LivenessDetectionFragment_wrapper.mInstance, param1 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public boolean isFragmentAdded(LivenessDetectionFragment_wrapper param0,
			Activity param1) throws Exception {
		Class cls = null;
		Object str = null;
		try {
			cls = Class
					.forName("com.yitutech.face.yitulivenessdetectionsdk.sdk.LivenessDetectionSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("isFragmentAdded", new Class[] {
					LivenessDetectionFragment.class, Activity.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "isFragmentAdded is null");
			str = _setAppInfo.invoke(mInstance, new Object[] {
					LivenessDetectionFragment_wrapper.mInstance, param1 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return (Boolean) str;
	}

	public void setDebugMode(boolean param0) throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.yitulivenessdetectionsdk.sdk.LivenessDetectionSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("setDebugMode",
					new Class[] { boolean.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "setDebugMode is null");
			_setAppInfo.invoke(mInstance, new Object[] { param0 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void setVerifyType(int param0) throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.yitulivenessdetectionsdk.sdk.LivenessDetectionSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("setVerifyType",
					new Class[] { int.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "setVerifyType is null");
			_setAppInfo.invoke(mInstance, new Object[] { param0 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void setDebugTextHint(boolean param0) throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.yitulivenessdetectionsdk.sdk.LivenessDetectionSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("setDebugTextHint",
					new Class[] { boolean.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "setDebugTextHint is null");
			_setAppInfo.invoke(mInstance, new Object[] { param0 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
