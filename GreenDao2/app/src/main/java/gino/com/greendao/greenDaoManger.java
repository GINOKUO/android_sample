package gino.com.greendao;

import gino.com.greendaoFile.DaoMaster;
import gino.com.greendaoFile.DaoSession;

/**
 * Created by gino_kuo on 2018/9/18.
 */

public class greenDaoManger {

    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static greenDaoManger mInstance;

    private greenDaoManger() {
        if (mInstance == null) {
            DaoMaster.DevOpenHelper devOpenHelper = new
                    DaoMaster.DevOpenHelper(MainActivity.getContext(),"user-db",null);
            mDaoMaster = new DaoMaster(devOpenHelper.getWritableDb());
            mDaoSession = mDaoMaster.newSession();
        }
    }

    public static greenDaoManger getInstance() {
        if(mInstance == null) {
            synchronized (greenDaoManger.class) {
                if(mInstance == null) {
                    mInstance = new greenDaoManger();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getMaster(){
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }

}
