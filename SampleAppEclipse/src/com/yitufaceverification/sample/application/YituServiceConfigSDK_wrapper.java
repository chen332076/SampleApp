package com.yitufaceverification.sample.application;

import java.lang.reflect.Method;

import com.yitutech.face.videorecordersdk.YituServiceConfigSDK.ServiceType;

import android.util.Log;

public class YituServiceConfigSDK_wrapper {
	public static void setServiceURL(ServiceType param0, String param1)
			throws Exception {
		Class cls = null;
		try {
			cls = Class
					.forName("com.yitutech.face.yitufaceverificationsdk.YituServiceConfigSDK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method _setAppInfo = null;
		try {
			_setAppInfo = cls.getDeclaredMethod("setServiceURL", new Class[] {
					ServiceType.class,
					String.class });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (_setAppInfo == null)
				Log.e("cxl1", "setServiceURL is null");
			_setAppInfo.invoke(cls, new Object[] { param0, param1 });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}


}
