 abstract class Tv{
 abstract void play();
}
 class HaierTv extends Tv{
	 void play(){
		System.out.println("This is HaierTv.");
	}
}
 class HvTv extends Tv{
	 void play(){
		System.out.println("This is HvTv.");
	}
}
 class TvFactory{  
	 public static Tv produceTv(String brand){
			 
		 if(brand.equals("HvTv"))
			 return new HvTv();
		 else if(brand.equals("HaierTv"))
			 return new HaierTv();
		 else
			 return null;
		 
	 }
 }
 interface TvFactory{ 
	 public Tv produceTv();
 }
 class HaierTvFactory implements Tvfactory{
	 public Tv produceTv(){
		 return new HaierTv();
	 }
 }
 class HvTvFactory implements Tvfactory{
	 public Tv produceTv(){
		 return new HvTv();
	 }
 }
public class Yu {

}
