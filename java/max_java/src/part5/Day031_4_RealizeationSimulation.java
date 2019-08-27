package part5;


public class Day031_4_RealizeationSimulation {

   public static void main(String[] args) {
      Day031_1_Parent ip = new Day031_3_Realizeation();//ip를 통해 메소드a 호출 가능한지 
      Day031_3_Realizeation rt = new Day031_3_Realizeation();//rt를 통해 메소드a 호출 가능한지 
      /*
       * 완결편
       * 자식은 부모가 가진 모든것들을 누릴 수 있다.
       * 하지만 부모타입은 자신에게 있고 자식에게 있는것 - 가능 
       * 자식에는 있지만 자신에게는 없는것 - 불가능  
       */
      //ip.methodA();
      rt.methodA();

   }

}