package com.uaoanlao.uaoanlibrary;

public class UaoanText {

    //截取
    public String qc(final String _message, final String _obj2, final String _obj3) {
        String message=_message;
        Object obj2=(String)_obj2;
        Object obj3=(String)_obj3;

        String a = message;//赋值
        //判断a值长度是否为零
        if (a.length() == 0) {
            return null;
        }

        int indexOf;
        if (obj2 != null) {
            int indexOf2;
            int length = a.length();
            if (obj2 instanceof String) {
                String str = (String) obj2;
                indexOf = a.indexOf(str);
                if (indexOf == -1) {
                    return null;
                }
                indexOf += str.length();
            } else if (!(obj2 instanceof Number)) {
                return null;
            } else {
                indexOf = ((Number) obj2).intValue();
                if (indexOf < 0 || indexOf > length) {
                    return null;
                }
            }
            if (obj3 instanceof String) {
                indexOf2 = a.indexOf((String) obj3, indexOf);
                if (indexOf2 == -1) {
                    return null;
                }
            } else if (!(obj3 instanceof Number)) {
                return a.substring(indexOf);
            } else {
                indexOf2 = ((Number) obj3).intValue();
                if (indexOf2 < 0 || indexOf2 > length) {
                    return null;
                }
            }
            return indexOf > indexOf2 ? null : a.substring(indexOf, indexOf2);
        } else if (obj3 instanceof String) {
            indexOf = a.indexOf((String) obj3);
            return indexOf == -1 ? null : a.substring(0, indexOf);
        } else if (!(obj3 instanceof Number)) {
            return null;
        } else {
            indexOf = ((Number) obj3).intValue();
            return (indexOf < 0 || indexOf > a.length()) ? null : a.substring(0, indexOf);
        }
    }


    //倒查
    public double dc(final Object _obj, final Object _obj2) {
        if (!(_obj instanceof String) || !(_obj2 instanceof String)) {
            return -1;
        }
        return b((String) _obj, (String) _obj2);
    }
    public int b(String str, String str2) {
        return str.lastIndexOf(str2);
    }

    public int b(String str, String str2, int i2) {
        return str.lastIndexOf(str2, i2);
    }

    public String b(String str) {
        return str.trim();
    }
    public String b(String str, String str2, String str3) {
        int indexOf;
        int i2 = 0;
        if (str2 != null) {
            int indexOf2 = str.indexOf(str2);
            if (indexOf2 == -1) {
                return null;
            }
            i2 = indexOf2 + str2.length();
        }
        if (str3 == null) {
            indexOf = str.length();
        } else {
            indexOf = str.indexOf(str3, i2);
            if (indexOf == -1) {
                return null;
            }
        }
        return str.substring(i2, indexOf);
    }

    public String[] b(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return null;
        }
        int length = java.lang.reflect.Array.getLength(obj);
        if (length <= 0) {
            return new String[0];
        }
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = java.lang.reflect.Array.get(obj, i2).toString();
        }
        return strArr;
    }

    //是否等于
    public boolean equals(String text1,String text2){
        return text1.equals(text2);
    }

    //是否包含
    public boolean contains(String text1,String text2){
        return text1.contains(text2);
    }

    //替换字符
    public void th(String text1,String text2,String text3){
        text1.replace(text2,text3);
    }
}
