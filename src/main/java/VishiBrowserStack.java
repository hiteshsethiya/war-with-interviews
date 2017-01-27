import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by racit-2105 on 22/01/17.
 */
public class VishiBrowserStack {

    public static final String FILTER_START = "***************###############***************";
    public static final String LOG_STARTS_WITH = "started";

    static class Filter {
        String requestType;
        String relativeUrl;
        String ip;
        String requestFormat;
        String responseCode;
//        requestType: GET|POST|PUT|DELETE
//        relativeUrl: /main/index or / , etc.
//                ip: 111.119.206.2 or 127.0.0.1, etc.
//                requestFormat: JS or JSON or HTML or null/blank, etc. (Note: null/blank request format should be treated as HTML.)
//        responseCode: "200 OK" or "401 Unauthorized" or "422 Unprocessable Entity", etc

    }

    static boolean isStartOfFilterInput(String in) {
        return FILTER_START.equalsIgnoreCase(in);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        List<String> logs = new ArrayList<String>();
        Filter filter = new Filter();
        HashMap<String,Long> filterFreq = new HashMap<String, Long>();

        StringBuilder logStatement = new StringBuilder();
        while(in.hasNextLine()) {
            String logInput = in.nextLine();
            if(!logInput.isEmpty()) {
                if(isStartOfFilterInput(logInput)) {
                    //Start of filter input

                    logs.add(logStatement.toString());

                    filter.requestType = in.nextLine();
                    filter.relativeUrl = in.nextLine();
                    filter.ip = in.nextLine();
                    filter.requestFormat = in.nextLine();
                    filter.responseCode = in.nextLine();
                    //Bad code above, need to refactor
                    filterFreq.put(filter.requestType,0L);
                    filterFreq.put(filter.relativeUrl,0L);
                    filterFreq.put(filter.ip,0L);
                    filterFreq.put(filter.requestFormat,0L);
                    filterFreq.put(filter.responseCode,0L);
                    //End of all input. Break the hasNext loop here
                    break;
                } else { //Ignore empty strings
                    //Get input till STARTED and push it to one log statement
                    if(LOG_STARTS_WITH.equalsIgnoreCase(logInput.substring(0,LOG_STARTS_WITH.length())) && logStatement.length() > 0) {
                        //This means next line of logs have started
                        logs.add(logStatement.toString());
                        logStatement = new StringBuilder();
                        logStatement.append(logInput);
                    } else {
                        //Keep appending it to the current log statement
                        logStatement.append(logInput);
                    }
                }
            }
        }

        //All data available in filter object and logs array
//        for(String st : logs) {
//            System.out.println(st);
//        };



        for(String log : logs) {

            if(log.substring(LOG_STARTS_WITH.length(), 15).contains(filter.requestType)) {
                filterFreq.put(filter.requestType, filterFreq.get(filter.requestType) + 1);
            }

            //URL
            Integer firstApostrophe = log.indexOf("\"", LOG_STARTS_WITH.length());
            Integer endApostrophe = 0;
            if(firstApostrophe >= 0) {
                endApostrophe = log.indexOf("\"", firstApostrophe + 1);
                if(endApostrophe > 0) {
                    String url = log.substring(firstApostrophe + 1,endApostrophe);
                    if(filter.relativeUrl.equalsIgnoreCase(url)) {
                        filterFreq.put(filter.relativeUrl, filterFreq.get(filter.relativeUrl) + 1);
                    }
                }
            }

            Integer ipIndex = log.indexOf(filter.ip, endApostrophe);
            if(ipIndex > -1) {
                filterFreq.put(filter.ip, filterFreq.get(filter.ip) + 1);
            }

            ipIndex = ipIndex < 0 ? 0 : ipIndex;
            String responseStr = log.substring(ipIndex);
            if(responseStr.toLowerCase().contains(filter.responseCode.toLowerCase())) {
                filterFreq.put(filter.responseCode, filterFreq.get(filter.responseCode) + 1);
            }

            Integer indexOfProcessing = log.indexOf("Processing", ipIndex);
            if(indexOfProcessing > -1) {
                String processingSubStr = log.substring(indexOfProcessing,log.indexOf("as",indexOfProcessing) + 15);
                if(processingSubStr.contains(filter.requestFormat)) {
                    filterFreq.put(filter.requestFormat, filterFreq.get(filter.requestFormat) + 1);
                }
            } else {
                if(filter.requestFormat.equalsIgnoreCase("HTML")) {
                    filterFreq.put(filter.requestFormat, filterFreq.get(filter.requestFormat) + 1);
                }

            }

        }


            System.out.println(filterFreq.get(filter.requestType));
            System.out.println(filterFreq.get(filter.relativeUrl));
            System.out.println(filterFreq.get(filter.ip));
            System.out.println(filterFreq.get(filter.requestFormat));
            System.out.println(filterFreq.get(filter.responseCode));


    }
}
