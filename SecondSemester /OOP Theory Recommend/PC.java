package SirMoseenPrograms;

public class PC {
    private String microprocessor;
    private int ram,hardiskMemory;
    Keyboard k;
    PC(String m,int r,int h){
        this.microprocessor=m;
        this.hardiskMemory=h;
        this.ram=r;
    }
    public void setMicro(String m)
    {
        this.microprocessor=m;
    }
    public void setHardisk(int h)
    {
        this.hardiskMemory=h;
    }
    public void setRam(int r)
    {
        this.ram=r;
    }
    public Keyboard addKey(Keyboard k)
    {
        return this.k=k;
    }
    public Keyboard change(Keyboard k)
    {
        return this.k=k;
    }
    public String getMicro()
    {
        return microprocessor;
    }
    public int getRam()
    {
        return this.ram;
    }
    public int getHardisk()
    {
        return hardiskMemory;
    }
    public String toString()
    {
        return "Microprocessor:"+this.microprocessor+"\nHardisk Memory:"+this.hardiskMemory
                +"\nRam:"+this.ram+"\nKeyBoard:"+this.k;
    }
}
