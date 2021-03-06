package dataArt;

/**
 * Created with IntelliJ IDEA.
 * User: M
 * Date: 28.10.13
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */
public class AK74 extends Thread
{
    public static void main(String[] args) throws InterruptedException
    {
        AK74 ak74 = new AK74();
        Magazine m = new Magazine(30);
        ak74.setMag(m);
        ak74.setTriggerToFullAutomatic();
        ak74.pullChargingHandle();
        ak74.pullTheTrigger();
        Thread.sleep(1000);
        ak74.setTriggerOff();
    }

    private int trigger = 0; //предохронитель
    private Magazine mag;     //магазин по умолчанию
    private boolean chargingHandle = false;   //затвор
    private boolean bayonet;   //штык-нож
    private ReflexSight reflexSight;    //Прицел
    //private volatile boolean stopS = false;

    public void setTriggerOff()
    {
        interrupt();
    }



    boolean isReady() {
        try {
        return mag != null  && chargingHandle && trigger > 0;
        } catch (NullPointerException e) {
            System.out.println("Add magazine.");
        }
        return false;
    }


    public void setReflexSight(ReflexSight reflexSight)
    {
        this.reflexSight = reflexSight;
    }

    public AK74()             //конструктор по умолчанию
    {

    }

    public AK74(Magazine mag)    //конструктор с заданым магазином
    {
        this.mag = mag;

       // bulletsInMag = mag.getBullets();
    }

    public void pullTheTrigger ()
    {
        start();
    }
    public void run ()
    {
        try {
    switch (trigger)
    {
        case (0) :
        break; //do nothing
        case (1) :
        shoot();
        break;
        case (2) :
        while ( !isInterrupted() )
            shoot();
        break;
    }
        }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt(); // very important
            }
    }

    public void shoot() throws InterruptedException       //метод выстрела
    {
        if(isReady())
            if (chargingHandle )
            {
        int bullet = mag.getBullets(); //этот метод гарантированно уменьшает количество патрон в магазине
        if (bullet > 0)
        {
            //System.out.println(mag.getBullets());
            System.out.println("BANG!");
            Thread.sleep(100);  //задержка между выстрелами, при 600 выстрелов минуту
        }
        else
        {
            System.out.println("Clats, no more bullets");
            chargingHandle = false;
        }
        }
    }


    public void setMag(Magazine mag)   //добавление магазина
    {
        this.mag = mag;
      //  bulletsInMag = mag.getBullets();
    }

    public void addMoreB (int aB)   //добавление патронов в магазин
    {
        mag.loadBullet(aB);
        //bulletsInMag = mag.getBullets();
    }


    public void setTriggerToOff()     //установка предохранителя
    {
        this.trigger = 0;
    }

    public void setTriggerToSemiAutomatic()   //установка предохранителя в полуавтоматический режим
    {
        this.trigger = 1;
    }

    public void setTriggerToFullAutomatic()  //установка предохранителя в автоматический режим
    {
        this.trigger = 2;
    }

    void pullChargingHandle ()    //взведение затвора перед стрельбой
    {

        chargingHandle = true;
    }

    public void addBayonet()     //добавление штык-ножа
    {
        this.bayonet = true;
    }

    public void hitWithABayonet()  //метод удара штыком
    {
        if(bayonet)
            System.out.println("AAA, DIE!");
        else
            System.out.println("Bayonet is not added");
    }
}

