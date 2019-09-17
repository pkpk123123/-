class Sun{
       
       private static Sun sun; // =new Sun();
       private Sun(){}
	
       private static int age;
       private static int hight; 
		
       static void speak(){
        
	System.out.println("my age is "+age+" and hight is "+hight+".");
         }

	
        public static Sun getSun(){
       	
	if(sun==null){
	  sun=new Sun();
                }
	return sun;
       }	
	       
}

public class Aa{

  public static void main(String [] args){

          Sun A=Sun.getSun();
          A.speak();
          
    }

}