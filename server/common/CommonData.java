package common;

public class CommonData
{
    public enum RAT
    {
        Bluetooth,
        WiFi,
        LTE_FDD,
        GSM,
        WCDMA
    };

    public enum RusVender
    {
        ERICSSON,
        NOKIA
    }

    public enum RFPort
    {
        RF_0,
        RF_1,
        RF_2,
        RF_3,
        RF_4,
        RF_5,
        RF_6,
        RF_7,
    }

    public enum LTE_Band
    {
        LTE_BAND_1,
        LTE_BAND_2,
        LTE_BAND_3,
        LTE_BAND_4,
        LTE_BAND_5,
        LTE_BAND_6,
        LTE_BAND_7,
        LTE_BAND_8
    }

    public enum WCDMA_Band
    {
        WCDMA_BAND_1,
        WCDMA_BAND_2,
        WCDMA_BAND_3,
        WCDMA_BAND_4,
        WCDMA_BAND_5,
        WCDMA_BAND_6,
        WCDMA_BAND_7,
        WCDMA_BAND_8
    }

    public enum RUAlarmStatusLevel
    {
        CRITICAL,
        MAJOR,
        MINOR,
        NO_ALARM,
        CRITICAL_ACKNOWLEDGED,
        MAJOR_ACKNOWLEDGED,
        MINOR_ACKNOWLEDGED
    }
}
