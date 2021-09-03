package com.zheng.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class DbUtil {
   private static ComboPooledDataSource ds=new ComboPooledDataSource();
   private static QueryRunner qr=new QueryRunner(ds);
    public static QueryRunner getQr(){
        return qr;
    }

}
