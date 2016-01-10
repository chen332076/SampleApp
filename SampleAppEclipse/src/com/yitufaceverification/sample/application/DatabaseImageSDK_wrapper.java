package com.yitufaceverification.sample.application;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import android.app.Activity;
import android.util.Log;

import com.yitutech.face.utilities.datatype.UserInfo;

public class DatabaseImageSDK_wrapper {

	private static Object mInstance;
	private static DatabaseImageSDK_wrapper wrapper;

	// 此处应添加构造函数或单例模式
	public DatabaseImageSDK_wrapper(Activity a) {
		Object item = null;
		try {
			Class classType = Class
					.forName("com.yitutech.face.databaseimagesdk.upload.DatabaseImageSDK");
			Constructor<?> cons[] = classType.getConstructors();
			item = cons[0].newInstance(a);
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

	public void uploadDatabaseImage(UserInfo param0, Integer param1,
			byte[] param2) throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.upload.DatabaseImageSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls
					.getDeclaredMethod("uploadDatabaseImage", new Class[] {
							UserInfo.class, Integer.class, byte[].class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "uploadDatabaseImage is null");
			_setAppInfo.invoke(mInstance,
					new Object[] { param0, param1, param2 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public List checkDatabaseImageStatus(UserInfo param0) throws Exception {
		Class cls = null;
		Object str = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.upload.DatabaseImageSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("checkDatabaseImageStatus",
					new Class[] { UserInfo.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "checkDatabaseImageStatus is null");
			str = _setAppInfo.invoke(mInstance, new Object[] { param0 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return (List) str;
	}

	public static void setDebugMode(boolean param0) throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.databaseimagesdk.upload.DatabaseImageSDK");
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
			_setAppInfo.invoke(cls, new Object[] { param0 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
