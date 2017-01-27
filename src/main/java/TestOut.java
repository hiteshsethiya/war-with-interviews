import java.util.Scanner;

/**
 * Created by racit-2105 on 22/01/17.
 */
public class TestOut {

    public static final String FILTER_START = "***************###############***************";
    public static final String LOG_STARTS_WITH = "started";
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

//        while(in.hasNextLine()) {
//            String logInput = in.nextLine();
//            String see = in.nextLine();
//            System.out.println(logInput.contains(see));
//        }
        String log = "Started GET \"/terminal/is_on?ts=1448979663546&b=Chrome&v=46.0&timestamp=1448979524369&sl=1421&tabOpened=1448979396.012\" for 127.0.0.1 at Tue Dec 01 19:51:03 +0530 2015  Processing by TerminalController#is_on as JSON  Parameters: {\"tabOpened\"=>\"1448979396.012\", \"v\"=>\"46.0\", \"b\"=>\"Chrome\", \"ts\"=>\"1448979663546\", \"sl\"=>\"1421\", \"timestamp\"=>\"1448979524369\"}[BS_SESSION_LOG 218] 3 : Tue Dec 01 19:51:04 +0530 2015 : /terminal/is_on : before requestLIVE SESSION LOGS [Tue Dec 01 14:21:04 UTC 2015] [SummaryLog Transition] - User: 3 - Inside terminal#is_on - sl - 1421 - Session: 627632189903c04da7801aafbac4d992 - bs_session_id: 218UnLocking session id 627632189903c04da7801aafbac4d992, bs_session id: 627632189903c04da7801aafbac4d992[BS_SESSION_LOG 218] 3 : Tue Dec 01 19:51:04 +0530 2015 : /terminal/is_on : after request : trueCompleted 200 OK in 546ms (Views: 13.3ms | ActiveRecord: 28.9ms | Sphinx: 0.0ms)";
        String relativeUrl = "/terminal/is_on?ts=1448979663546&b=Chrome&v=46.0&timestamp=1448979524369&sl=1421&tabOpened=1448979396.012";
        int count = 0;
        Integer firstApostrophe = log.indexOf("\"", LOG_STARTS_WITH.length());
        if(firstApostrophe >= 0) {
            Integer endApostrophe = log.indexOf("\"", firstApostrophe + 1);
            if(endApostrophe >= 0) {
                String url = log.substring(firstApostrophe + 1,endApostrophe);
                if(relativeUrl.equalsIgnoreCase(url)) {
                    //filterFreq.put(filter.relativeUrl, filterFreq.get(filter.relativeUrl) + 1);
                    ++count;
                }
            }
        }
    }

}
