package ro.pub.cs.systems.eim.practicaltest01;

import java.util.ArrayList;

public class Constants {

    public static final String LEFT_TEXT = "left_text";
    public static final String RIGHT_TEXT = "right_text";
    public static final int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    public static final String ACTION_1 = "ro.pub.cs.systems.eim.practicaltest01.action.action_1";
    public static final String ACTION_2 = "ro.pub.cs.systems.eim.practicaltest01.action.action_2";
    public static final String ACTION_3 = "ro.pub.cs.systems.eim.practicaltest01.action.action_3";

    public static final ArrayList<String> actions = new ArrayList<String>() {{
        add(ACTION_1);
        add(ACTION_2);
        add(ACTION_3);
    }};
    public static final String SERVICE_LOG = "service_log";

    public static final int THRESHOLD = 5;

    public static final String TAG = "PracticalTest01";
}
