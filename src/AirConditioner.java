public class AirConditioner {
    private boolean isOn = false;
    private String productName;
    private int temperature;


    public AirConditioner(String productName){
        this.productName = productName;
    }

    public void setOn(boolean setOn) {
       isOn = setOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setProductName(String productName) {
        if(isOn){ this.productName = productName;}
        else this.productName = null;
    }

    public String getProductName() {
        if(isOn){ return productName;}
        else return null;
    }

    public void setTemperature(int temperature) {
        if (isOn && temperature > 0 && temperature <=30)
       this.temperature = temperature;
        else
            this.temperature = 16;
    }

    public int getTemperature() {
        if (isOn) return temperature;
        else return 0;
    }

    public void increaseTemperature() {
        if (isOn) temperature++; }

    public void decreaseTemperature() {
        if(isOn) temperature--; }
}
