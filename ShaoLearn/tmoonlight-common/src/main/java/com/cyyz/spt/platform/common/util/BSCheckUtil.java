package com.cyyz.spt.platform.common.util;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 业务检查
 *
 */
public class BSCheckUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(BSCheckUtil.class);

	private static final String STAFF_SEAL_NAME = "行政章";
	private static final String LEGAL_SEAL_NAME = "法定名称章";
	public static final String CHECK_ALERT_MSG="该单位已有[{}],请勿重复申请";
	
	/**
	 * 行政章是法定名称章，需要判断是否存在重复
	 * @param sealName
	 * @param unitSealNameSet DB中的数据
	 * @return
	 */
	public static boolean checkRepeatSealNameForStaff (String sealName ,Set<String> unitSealNameSet) {
		
		if(unitSealNameSet == null) {
			return false;
		}
		
		//如果是行政章，判断DB中是否有法定名称章
		if(sealName.equals(STAFF_SEAL_NAME)) {
			for(String name : unitSealNameSet) {
				if(name.equals(LEGAL_SEAL_NAME)) {
					return true;
				}
			}
		}
		
		if(sealName.equals(LEGAL_SEAL_NAME)) {
			for(String name : unitSealNameSet) {
				if(name.equals(STAFF_SEAL_NAME)) {
					return true;
				}
			}
		}
		
		/*
		boolean mark = staffSealAlias(unitSealNameSet);
		
		if(mark && sealName.equals(LEGAL_SEAL_NAME)) {
			logger.info(CHECK_ALERT_MSG , sealName);
			return true;
		}
		*/
		return false;
	}
	
	/**
	 * 是否存在行政章或者法定名称章
	 * @param unitSealNameSet DB中的数据
	 * @return
	 */
	public static boolean staffSealAlias(Set<String> unitSealNameSet) {
		boolean mark = false;
		for(String name : unitSealNameSet) {
			if(STAFF_SEAL_NAME.equals(name) || LEGAL_SEAL_NAME.equals(name)) {
				mark = true;
				break;
			}
		}
		
		return mark;
	}
}
