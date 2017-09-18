public class Pyramid extends ThreeDimShape {

    @Override
    public double getVolume(){
        return super.getVolume()/3;
    }
}
