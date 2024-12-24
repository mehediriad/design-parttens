class Singleton {
    private static Singleton instance; // স্ট্যাটিক ভেরিয়েবল
    
    // প্রাইভেট কন্সট্রাক্টর
    private Singleton() {}

    // স্ট্যাটিক মেথড যা ইনস্ট্যান্স প্রদান করে
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); // নতুন ইনস্ট্যান্স তৈরি
        }
        return instance; // পূর্বের ইনস্ট্যান্স রিটার্ন
    }

    public void showMessage() {
        System.out.println("This is Singleton Instance");
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        instance1.showMessage(); // Output: This is Singleton Instance

        // ইনস্ট্যান্স দুটি একই কি না পরীক্ষা
        System.out.println(instance1 == instance2); // Output: true
    }
}
