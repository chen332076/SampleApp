package com.yitufaceverification.sample.application;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.yitutech.camerasdk.CameraManager;
import com.yitutech.face.databaseimagesdk.fanpaizhao.OnDatabaseImageCapturedEventListener;
import com.yitutech.face.utilities.datatype.AccessInfo;

public class CaptureDatabaseImageFragment_wrapper extends Fragment {

	private static Object mInstance;
	private static CaptureDatabaseImageFragment_wrapper wrapper;

	public static CaptureDatabaseImageFragment_wrapper newInstance(Activity a,
			AccessInfo b, OnDatabaseImageCapturedEventListener c, int d) {
		if (wrapper == null) {
			wrapper = new CaptureDatabaseImageFragment_wrapper();
		}
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Method _getInstance = null;
		try {
			_getInstance = cls.getDeclaredMethod("getInstanse", new Class[] {
					Activity.class, AccessInfo.class,
					OnDatabaseImageCapturedEventListener.class, int.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		Object item = null;
		try {
			item = _getInstance.invoke(cls, new Object[] { a, b, c, d });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		mInstance = item;
		return wrapper;
	}

	public static CaptureDatabaseImageFragment_wrapper newInstance(Activity a,
			AccessInfo b, OnDatabaseImageCapturedEventListener c, int d,
			Handler f) {

		if (wrapper == null) {
			wrapper = new CaptureDatabaseImageFragment_wrapper();
		}
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Method _getInstance = null;
		try {
			_getInstance = cls.getDeclaredMethod("getInstanse", new Class[] {
					Activity.class, AccessInfo.class,
					OnDatabaseImageCapturedEventListener.class, int.class,
					Handler.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		Object item = null;
		try {
			item = _getInstance.invoke(cls, new Object[] { a, b, c, d, f });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		mInstance = item;
		return wrapper;
	}

	public void onClick() throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("onClick", new Class[0]);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "onClick is null");
			_setAppInfo.invoke(mInstance, null);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public boolean onTouch(View param0, MotionEvent param1) throws Exception {
		Class cls = null;
		Object str = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("onTouch", new Class[] {
					View.class, MotionEvent.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "onTouch is null");
			str = _setAppInfo
					.invoke(mInstance, new Object[] { param0, param1 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return (Boolean) str;
	}

	@Override
	public void onCreate(Bundle param0) {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("onCreate",
					new Class[] { Bundle.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "onCreate is null");
			try {
				_setAppInfo.invoke(mInstance, new Object[] { param0 });
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onResume() {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("onResume", new Class[0]);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "onResume is null");
			try {
				_setAppInfo.invoke(mInstance, null);
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public View onCreateView(LayoutInflater param0, ViewGroup param1,
			Bundle param2) {
		Class cls = null;
		Object str = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("onCreateView", new Class[] {
					LayoutInflater.class, ViewGroup.class, Bundle.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "onCreateView is null");
			try {
				str = _setAppInfo.invoke(mInstance, new Object[] { param0,
						param1, param2 });
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return (View) str;
	}

	@Override
	public void onAttach(Activity param0) {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("onAttach",
					new Class[] { Activity.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "onAttach is null");
			try {
				_setAppInfo.invoke(mInstance, new Object[] { param0 });
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDetach() {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("onDetach", new Class[0]);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "onDetach is null");
			try {
				_setAppInfo.invoke(mInstance, null);
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public Bitmap cutIdcardImage(Bitmap param0) throws Exception {
		Class cls = null;
		Object str = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("cutIdcardImage",
					new Class[] { Bitmap.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "cutIdcardImage is null");
			str = _setAppInfo.invoke(mInstance, new Object[] { param0 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return (Bitmap) str;
	}

	public void onPictureTaken(byte[] param0, CameraManager.CameraProxy param1)
			throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("onPictureTaken", new Class[] {
					byte[].class, CameraManager.CameraProxy.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "onPictureTaken is null");
			_setAppInfo.invoke(mInstance, new Object[] { param0, param1 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void run() throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("run", new Class[0]);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "run is null");
			_setAppInfo.invoke(mInstance, null);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onStop() {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("onStop", new Class[0]);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "onStop is null");
			try {
				_setAppInfo.invoke(mInstance, null);
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onPause() {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.fanpaizhao.CaptureDatabaseImageFragment");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("onPause", new Class[0]);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "onPause is null");
			try {
				_setAppInfo.invoke(mInstance, null);
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
