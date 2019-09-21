package com.kimmy.easycreate.util;

import java.util.List;

import com.kimmy.easycreate.po.ProgramFieldRelation;

public class StringUtil {

	public static boolean isEmpty(List<ProgramFieldRelation> unExistFieldList) {
		return null == unExistFieldList || unExistFieldList.isEmpty();
	}

}
