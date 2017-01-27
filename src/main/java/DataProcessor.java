//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.math.BigInteger;
//
///**
// * @author Hitesh Sethiya
// */
//public class DataProcessor implements Runnable {
//
//    private static final double gain = 24;
//    private static final double Vref = 4.5;
//    private static final double check = Math.pow(2, 23);
//    private static final double check_divide = 2 * check;
//
//    public static final int MINIMUM_DATA_IN_FILE = 100;
//    private static final int ONE_CHANNEL_SAMPLE_LENGTH = 6;
//    private static final int MINIMUM_PROCESSING_LENGTH = 15008;
//    private static final int MINIMUM_LENGTH_FOR_DATA_DISPLAY = 15000;
//    private static final int NO_OF_CHANNELS = 4;
//    private static final int NO_OF_SAMPLES_INLINE = 14;
//    private static final int MIN_NO_OF_LINES = 1072;
//    private static final String STARTS_WITH_CHAR = "\\+";
//    private double[][] mChannelsData;
//    private static int mChannelDataPrevIndex;
//    private static int mChannelDataCurrentIndex;
//    private static int mSampleFirstCharacterAsciiVal;
//    private static int mFirstValidPacketPos = -1;
//    private static int mTotalPacketsCount;
//    private static int mLineIndex = 0;
//
//    private volatile boolean isRunning; //Volatile because, DataStream thread writes to it and DataProcessor thread reads it.
//
//    private static DataProcessor DATA_PROCESSOR_INSTANCE;
//
//    private DataProcessor() {
//        initialiseChannels();
//    }
//
//    private Context mContext;
//
//    private DataProcessor(Context context) {
//        mContext = context;
//        initialiseChannels();
//    }
//
//    public static DataProcessor getInstance(Context context) {
//        synchronized (DataProcessor.class) {
//            if(DATA_PROCESSOR_INSTANCE == null) {
//                DATA_PROCESSOR_INSTANCE = new DataProcessor(context);
//            }
//        }
//        return DATA_PROCESSOR_INSTANCE;
//    }
//
//    public void initialiseChannels() {
//        mChannelsData = new double[NO_OF_CHANNELS][MINIMUM_PROCESSING_LENGTH]; // 15K columns and 4 rows
//    }
//
//    public double[][] initialiseChannelsTemp() {
//        return (new double[NO_OF_CHANNELS][MINIMUM_PROCESSING_LENGTH]); // 15K columns and 4 rows
//    }
//
//    public void processDataStream() throws IOException {
////        File file = new File("/Users/racit-2105/Desktop/sattva-08-30-12-40-45.txt");
////        FileInputStream fileInputStream = new FileInputStream(file);
////        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
////        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//
//        Log.i(Constants.APP_LOG,"len: "+mChannelsData.length);
//        Log.i(Constants.APP_LOG,"at 0 len: " + mChannelsData[0].length);
//
//        for(String line = bufferedReader.readLine(); line != null && !line.isEmpty(); line = bufferedReader.readLine()) {
//            populateData(line, mLineIndex);
//            mTotalPacketsCount += line.split(STARTS_WITH_CHAR).length -1;
//            mLineIndex++;
//            if(mChannelDataCurrentIndex >= (MINIMUM_PROCESSING_LENGTH - 1) || mLineIndex >= MIN_NO_OF_LINES) {
//                filterAndReset();
//                printChannelData();
//            }
//        }
//    }
//
//    private void printChannelData() {
//        for(int i = 0; i < mChannelsData.length; ++i) {
//            for(int j = 0; j < mChannelsData[0].length; ++j) {
//                Log.i(Constants.APP_LOG,"(" + i + ")" + "{"+ j +"}" + mChannelsData[i][j]);
//            }
//            Log.i(Constants.APP_LOG,);
//        }
//        Log.i(Constants.APP_LOG,mChannelDataCurrentIndex);
//        Log.i(Constants.APP_LOG,mTotalPacketsCount);
//    }
//
//    private void populateData(String data, int sampleLineIndex) {
//        //separate out 15 samples with first sample as empty
//        String samples[] = data.split(STARTS_WITH_CHAR);
//
//        //process first sample line
//        if(sampleLineIndex == 0) {
//            processFirstSampleLine(samples);
//            return;
//        }
//
//        processFirstValidSampleOnward(1, samples);
//    }
//
//    private void processFirstSampleLine(String[] samples) {
//
//        for(int i = 1; i < samples.length; i++) {
//            String sample = samples[i];
//            if(isSampleValid(sample)) {
//                processSample(sample, 0);
//                mFirstValidPacketPos = i;
//                mSampleFirstCharacterAsciiVal = (int)sample.charAt(0);
//                break;
//            }
//        }
//        if(mFirstValidPacketPos == -1) {
//            Log.i(Constants.APP_LOG,"Something went wrong...Try Restarting the device");
//        } else {
//            // process first valid sample onwards
//            processFirstValidSampleOnward(mFirstValidPacketPos+1, samples);
//        }
//    }
//
//    private void processFirstValidSampleOnward(int validPos, String[] samples) {
//        for(int i = validPos; i<samples.length; i++) {
//            String ithSample = samples[i];
//            Log.i(Constants.APP_LOG,ithSample);
//            Log.i(Constants.APP_LOG,"each sample ith Processed Data ==> " + i);
//            Log.i(Constants.APP_LOG,"Last Char value ==> " + mSampleFirstCharacterAsciiVal);
//            if(isSampleValid(ithSample)) {
//                int interpolationSampleCount = populateInterpolationSampleCount(ithSample);
//                if(interpolationSampleCount > 0) {
//                    processSample(ithSample, populateMatrixIndex(interpolationSampleCount));
//                } else {
//                    processSample(ithSample, populateMatrixIndex(interpolationSampleCount));
//                    mSampleFirstCharacterAsciiVal = (int) ithSample.charAt(0);
//                    mChannelDataCurrentIndex++;
//                    mChannelDataPrevIndex = mChannelDataCurrentIndex;
//                }
//                //check if there are any missing packets in between
//                if (checkIfAnyMissingPackets(ithSample)) {
//                    int missingPackets = getMissingPacketCount(mSampleFirstCharacterAsciiVal, ithSample.charAt(0));
//                    interpolate(mChannelDataPrevIndex+1 , populateMatrixIndex(missingPackets));
//                    mChannelDataCurrentIndex = populateMatrixIndex(missingPackets);
//                    mChannelDataPrevIndex = mChannelDataCurrentIndex;
//                    mSampleFirstCharacterAsciiVal = (int) ithSample.charAt(0);
//                } else if(checkIfAnyWrongSamples()){
//                    interpolate(mChannelDataPrevIndex+1 , mChannelDataCurrentIndex);
//                    mChannelDataPrevIndex = mChannelDataCurrentIndex;
//                    mSampleFirstCharacterAsciiVal = (int) ithSample.charAt(0);
//                }
//                if(mChannelDataCurrentIndex == 14992) {
//                    Log.i(Constants.APP_LOG,"each sample ith Processed Data ==> " + mChannelDataCurrentIndex);
//                }
//            }
//        }
//    }
//
//    private int populateMatrixIndex(int missingPackets) {
//        if(missingPackets > 0) {
//            return mChannelDataCurrentIndex + missingPackets + 1;
//        } else {
//            return mChannelDataCurrentIndex + 1;
//        }
//    }
//
//    private int populateInterpolationSampleCount(String sample) {
//        if(checkIfAnyMissingPackets(sample)) {
//            return getMissingPacketCount(mSampleFirstCharacterAsciiVal, sample.charAt(0));
//        }
//
//        if(checkIfAnyWrongSamples()) {
//            return mChannelDataCurrentIndex - mChannelDataPrevIndex;
//        }
//
//        return 0;
//    }
//
//    private int getMissingPacketCount(int val1, int val2) {
//        if(val2 > val1) {
//            return val2 - val1 - 1;
//        }
//
//        int diff1 = '=' - val1;
//        int diff2 = val2 - '0';
//        int totalDiff = diff1 + diff2;
//        return totalDiff;
//    }
//
//    private boolean checkIfAnyWrongSamples() {
//        if(mChannelDataCurrentIndex - mChannelDataPrevIndex > 0) {
//            return true;
//        }
//        return false;
//    }
//
//    private boolean checkIfAnyMissingPackets(String sample) {
//        if(Math.abs((int)sample.charAt(0) - mSampleFirstCharacterAsciiVal) > 1) {
//            return true;
//        }
//        return false;
//    }
//
//    private boolean isSampleValid(String sample) {
//        if(!sample.isEmpty() && sample.length() == 25) {
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * For every lost/corrupted sample, find the previous sample and the next sample, use the formula to interpolate.
//     * Add the interpolated value to the lost sample index.
//     * @param startIndex - should be in reference to the GLOBAL_SAMPLE_INDEXES
//     * @param endIndex - should be in reference to the GLOBAL_SAMPLE_INDEXES
//     */
//    public void interpolate(int startIndex, int endIndex) {
//        int noOfMissedPackets = (endIndex - startIndex);
//        Log.i(Constants.APP_LOG,"Begin interpolation for startIndex and end index "+startIndex + " : " + endIndex );
//        //Log.i(Constants.APP_LOG,"Missed samples "+ noOfMissedPackets);
//        if(startIndex <= 0) return; //ignore first couple of samples.
//        for(int globalLostSampleIndex = startIndex, primaryLi = 1; globalLostSampleIndex < endIndex; ++globalLostSampleIndex, ++primaryLi) {
//            Log.i(Constants.APP_LOG,"Interpolation at index "+ globalLostSampleIndex + "primary Li"+ primaryLi);
//            for(int channel = 0; channel < NO_OF_CHANNELS; ++channel) {
//                double previousSample = mChannelsData[channel][startIndex - 1];
//                double nextSample = mChannelsData[channel][endIndex];
//                double interpolatedSample = (((nextSample - previousSample) / (noOfMissedPackets+1)) * primaryLi) + previousSample; //formula
//                //Log.i(Constants.APP_LOG,"Interpolated sample " + interpolatedSample + " at index " + globalLostSampleIndex + " and channel " + channel);
//                addValueToChannel(channel,interpolatedSample,globalLostSampleIndex);
//            }
//        }
//    }
//
//    public void processSample(String microSample, int index) {
//        //Expecting microSample to be 6EF7ACFE418E3B21F60A3E704 with the starting character removed.
//        Log.i(Constants.APP_LOG,"this is the micro sample" + microSample);
//        for(int i = 1, channel = 0; channel < NO_OF_CHANNELS; ++channel ) {
//            String iThChannelHex = microSample.substring(i,i + ONE_CHANNEL_SAMPLE_LENGTH);
//            double value = doubleConvInt(new BigInteger(
//                    iThChannelHex, 16).doubleValue());
//            Log.i(Constants.APP_LOG,"ith hex value " + iThChannelHex + " processed Sample " + value + " this is the global index " + index + "");
//            addValueToChannel(channel, value, index);
//            i += ONE_CHANNEL_SAMPLE_LENGTH;
//        }
//    }
//
//    public void addValueToChannel(int channel, double sample, int index) {
//        mChannelsData[channel][index] = sample;
//    }
//
//    public boolean minSamplesCollected(int channel,int index) {
//        return (channel == 3 && index >= (MINIMUM_LENGTH_FOR_DATA_DISPLAY - 1 ));
//    }
//
//    public void filterAndReset() {
//        Log.i(Constants.APP_LOG,"Begin filterAndReset");
//        // Send a broadcast to filter thread.
//        double[][] tempChannelsData = initialiseChannelsTemp();
//
//        int copyTillIndex = mChannelDataCurrentIndex + 1;
//        int length = copyTillIndex - 10000;
//
//        for(int channelI = 0; channelI < NO_OF_CHANNELS; ++channelI) {
//            Log.i(Constants.APP_LOG,"Start time for copying channel "+channelI+" data - "+System.currentTimeMillis());
//            System.arraycopy(mChannelsData[channelI], 10000, tempChannelsData[channelI], 0, length);
//            Log.i(Constants.APP_LOG,"End time for copying channel "+channelI+" data - "+System.currentTimeMillis());
//        }
//
//        double[] channelData1 = getIthChannelsData(0);
//        double[] channelData2 = getIthChannelsData(1);
//        double[] channelData3 = getIthChannelsData(2);
//        double[] channelData4 = getIthChannelsData(3);
//        Intent intent = new Intent(mContext, FilterService.class);
//        intent.putExtra(Constants.CHANNEL1, channelData1);
//        intent.putExtra(Constants.CHANNEL2, channelData2);
//        intent.putExtra(Constants.CHANNEL3, channelData3);
//        intent.putExtra(Constants.CHANNEL4, channelData4);
//        mContext.startService(intent); //Transfer of reference
//        mChannelsData = tempChannelsData; //Disassociation of reference
//        mChannelDataCurrentIndex = length;
//        mChannelDataPrevIndex = mChannelDataCurrentIndex - 1;
//        mLineIndex = (length / NO_OF_SAMPLES_INLINE) + 1;
//    }
//
//    public double[] getIthChannelsData(int channel) {
//        return mChannelsData[channel];
//    }
//
//    public double getDataForChannelAtIndex(int channel,int index) {
//        return mChannelsData[channel][index];
//    }
//
//    public double doubleConvInt(double input) {
//        double out;
//        if (input >= check) {
//            out = (input - check_divide) * Vref / (check - 1) / gain;
//        } else {
//            out = input / (check - 1) / gain * Vref;
//        }
//        return out;
//
//    }
//
//    public boolean isRunning() {
//        return isRunning;
//    }
//
//    /**
//     * Synchronized to avoid updates to the value causing race conditions or stale reads.
//     * @param running status to be set.
//     */
//    public synchronized void setRunning(boolean running) {
//        isRunning = running;
//    }
//
//    public void terminate() {
//        setRunning(false);
//    }
//
//    public void run() {
//        try {
//            DATA_PROCESSOR_INSTANCE.processDataStream();
//        } catch (IOException e) {
//            Log.i(Constants.APP_LOG,"Exception in Data processing thread run.",e);
//        }
//    }
//
//}