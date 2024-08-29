package org.sawaklaudia;

public class DataInsertion {

    private AppLaunchType appLaunchType;

    public DataInsertion(AppLaunchType appLaunchType) {
        this.appLaunchType = appLaunchType;
    }

    public void runApp(){
        appLaunchType.runApp();
    }
}
