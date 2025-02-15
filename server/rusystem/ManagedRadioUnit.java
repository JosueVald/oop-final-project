package rusystem;

import java.util.HashMap;

import common.Response;

public class ManagedRadioUnit
{
    private RUState activatedState;
    private RUState idleState;
    private RUState deactivatedState;

    protected void setDeactivatedState(RUState deactivatedState) {
        this.deactivatedState = deactivatedState;
    }

    private RUState currentState;

    private String ipAddress;
    private String radioUnitName;
    private String radioVendor;
    private String ratType;
    private HashMap<Integer, Carrier> carriers; // or Carriers?
    private RadioUnitAlarmStatusLevels alarmStatus;

    public ManagedRadioUnit()
    {
        this.activatedState = new RUActivatedState(this);
        this.idleState = new RUIdleState(this);
        this.deactivatedState = new RUDeactivatedState(this);
        this.currentState = idleState;
        this.alarmStatus = RadioUnitAlarmStatusLevels.NO_ALARM;
        // this.radioUnitName
        // this.radioVendor
        // this.ratType
    }
    
    public Response triggerEvent(ManagedRuEvent managedRuEvent)
    {   
        switch(managedRuEvent) {
            case SETUP:
                currentState.setup();
                break;
            case ACTIVATE:
                currentState.setup();
                break;
            case DEACTIVATE:
                currentState.deactivate();
                break;
            case RELEASE:
                currentState.release();
                break;
            case SETUP_CARRIER:
                currentState.setupCarrier();
                break;
            case SIGNAL_SCALING:
                currentState.signalScaling();
                break;
            case MODIFY_CARRIER:
                currentState.modifyCarrier(0, "asdas");
                break;
            case REMOVE_CARRIER:
                currentState.removeCarrier(0);
                break;
            case SELF_DIAGNOSTICS:
                currentState.performSelfDiagnostics();
                break;
            case REMOVE_ALL_CARRIERS:
                currentState.removeAllCarriers();
                break;
            case SET_ALARM_STATUS:
                currentState.setAlarmStatus();
                break;
            case ACKNOWLEDGE_ALARM:
                currentState.acknowledgeAlarm();
                break;
            case POST_ACTIVATION:
                currentState.postActivation();
                break;
            default:
                System.out.println("Invalid event");
        }

        Response response = isTransitionPossible();
        if (response.isSuccessful)
        {
            response = transitionState();
            return response;
        }
        
        return response;
    }

    protected boolean removeCarrier(int carrierId) {
        if (!this.carriers.containsKey(carrierId)) {
            return false;
        }

        carriers.remove(carrierId);
        return true;
    }

    protected boolean removeAllCarriers() {
        carriers.clear();
        return true;
    }

    protected boolean modifyCarrier(int carrierId, String frequencyBand) {
        // TODO: Waiting for Carrier to be completed
        return true;
    }

    protected boolean setupCarrier() {
        // TODO: Waiting for Carrier to be completed
        return true;
    }

    protected boolean performSelfDiagnostics() {
        // TODO: perform self diagnostics
        return true;
    }

    private Response isTransitionPossible()
    {
        Response response = new Response(true, "That state transition is possible");
        return response;
    }
    
    private Response transitionState()
    {
        Response response = new Response(true, "Successfully transitioned the state");
        return response;
    }

    protected String getIpAddress() {
        return this.ipAddress;
    }

    protected void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    protected String getRadioUnitName() {
        return this.radioUnitName;
    }

    protected void setRadioUnitName(String radioUnitName) {
        this.radioUnitName = radioUnitName;
    }

    protected String getRadioVendor() {
        return this.radioVendor;
    }

    protected void setRadioVendor(String radioVendor) {
        this.radioVendor = radioVendor;
    }

    protected String getRatType() {
        return this.ratType;
    }

    protected void setRatType(String ratType) {
        this.ratType = ratType;
    }

    protected HashMap<Integer, Carrier> getCarriers() {
        return this.carriers;
    }

    protected void setCarriers(HashMap<Integer, Carrier> carriers) {
        this.carriers = carriers;
    }

    protected RadioUnitAlarmStatusLevels getAlarmStatus() {
        return this.alarmStatus;
    }

    protected void setAlarmStatus(RadioUnitAlarmStatusLevels alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    protected RUState getCurrentState() {
        return this.currentState;
    }

    protected void setCurrentState(RUState currentState) {
        this.currentState = currentState;
    }

    protected RUState getActivatedState() {
        return this.activatedState;
    }

    protected RUState getIdleState() {
        return this.idleState;
    }

    protected RUState getDeactivatedState() {
        return this.deactivatedState;
    }
}