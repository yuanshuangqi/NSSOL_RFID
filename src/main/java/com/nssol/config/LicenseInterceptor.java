package com.nssol.config;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.nssol.common.SecretUtil;

public class LicenseInterceptor implements HandlerInterceptor {

	private String licenseKey;
	
	public LicenseInterceptor(String licenseKey){
		this.licenseKey = licenseKey;
	}
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		if(!StringUtils.isEmpty(licenseKey)) {
			String decryptLicenseStr = SecretUtil.decrypt(licenseKey, SecretUtil.KEY);
			if(!StringUtils.isEmpty(decryptLicenseStr)) {
				String[] licenseArr = decryptLicenseStr.split("_");
				if(licenseArr.length==3) {
					if("NEVER".equals(licenseArr[1])) {
						return true;
					} else {
						if(licenseArr[1].length()==8) {
							String nowDateStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
							if(Integer.parseInt(nowDateStr)<Integer.parseInt(licenseArr[1])){
								return true;
							} else {
								setLicenseErrorInfo(response);
								return false;
							}
						} else {
							setLicenseErrorInfo(response);
							return false;
						}
					}
				} else {
					setLicenseErrorInfo(response);
					return false;
				}
			} else {
				setLicenseErrorInfo(response);
				return false;
			}
		} else {
			setLicenseErrorInfo(response);
			return false;
		}
	}
	
	private void setLicenseErrorInfo(HttpServletResponse response) throws IOException{
		OutputStream outputStream = response.getOutputStream();
		response.setHeader("content-type", "text/html;charset=UTF-8");
		byte[] dataByteArr = "LicenseError".getBytes("UTF-8");
		outputStream.write(dataByteArr);
	}
}
