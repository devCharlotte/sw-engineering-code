
// singleton pattern 

// edit by jh

public class Singleton {
    private static Singleton instance;  // 유일한 인스턴스 저장하는 정적 변수

    private Singleton() { // private으로  외부에서 인스턴스 생성 못 하도록 생성자 접근 제한. 
        
	// 생성자 실행 시 필요한 실행문이 있다면 작성

    }

    public synchronized static Singleton instance() {  
	// 인스턴스 리턴 & public static이라 각 스레드가 전역에서 접근 가능 
	// sync 하나의 스레드에 의해서만 실행이 보장되는 방식
	
        // 인스턴스가 아직 생성되지 않았다면, 새로 생성
        if (instance == null) {
            instance = new Singleton();
        }

        // 이미 인스턴스가 존재하면 기존의 인스턴스를 반환
        return instance;
    }
}

public static void main(String[] args) {
    
    Singleton singleton1 = Singleton.instance();  // 싱글톤 패턴 인스턴스 
            
    Singleton singleton2 = Singleton.instance();  // 새로운 인스턴스 생성되는 것이 아닌 기존의 것 저장

    // 두 인스턴스가 동일한지 확인하려면 같은 곳을 참조하는지 확인
    if (singleton1 == singleton2) {
        System.out.println("Both variables contain the same Singleton instance.");
    } 
    else {
            System.out.println("The instances are different.");
    }
}
