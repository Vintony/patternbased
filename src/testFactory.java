import model.*;


public class testFactory {
    public static void main(String[] args) {
        TweeterFactory listFactory = new TweeterListFactory();
        TweeterObject listObject = listFactory.create();
        listObject.declare();

        TweeterFactory abstractFactory = new TweeterAbstractFactory();
        TweeterObject abstractObject = abstractFactory.create();
        abstractObject.declare();

        TweeterFactory detailFactory = new TweeterDetailFactory();
        TweeterObject detailObject = detailFactory.create();
        detailObject.declare();
    }
}
