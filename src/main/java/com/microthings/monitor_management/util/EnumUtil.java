package com.microthings.monitor_management.util;

import com.microthings.monitor_management.Enum.IEnum;
import com.microthings.monitor_management.Enum.ILongEnum;

public class EnumUtil {

    /**
     * 整数
     * @param code
     * @param enumClass
     * @param <T>
     * @return
     */
    public static <T extends IEnum>T getByCode(Integer code, Class<T> enumClass){
        for(T each:enumClass.getEnumConstants()){
            if(each.getCode().equals(code)){
                return each;
            }
        }
        return null;
    }

    /**
     * 大整数
     * @param code
     * @param enumClass
     * @param <T>
     * @return
     */
    public static <T extends ILongEnum>T getLongByCode(Long code, Class<T> enumClass){
        for(T each:enumClass.getEnumConstants()){
            if(each.getCode().equals(code)){
                return each;
            }
        }
        return null;
    }
}
