// Week 1, Day 1: classes, constructors, access modifiers.
// Run:  java practice/week1/Day1.java      (needs JDK 17+)
//
// Your job: replace each TODO so that main() prints "OK" for every check.

public class Day1 {
    public static void main(String[] args) {
        Patient p = new Patient(1, "Amina Rakoto", "034 00 000 00");
        check("name", "Amina Rakoto".equals(p.getName()));
        check("id", p.getId() == 1);

        p.setPhone("034 11 111 11");
        check("phone changed", "034 11 111 11".equals(p.getPhone()));

        try {
            p.setPhone("  ");
            check("blank phone rejected", false);
        } catch (IllegalArgumentException e) {
            check("blank phone rejected", true);
        }

        // TODO 5: uncomment the next line. It must NOT compile. Read the error,
        //         then put the line back in a comment. Say in English why it fails.
        // p.name = "Hacked";
    }

    static void check(String label, boolean ok) {
        System.out.println((ok ? "OK    " : "FAIL  ") + label);
    }
}

class Patient {
    private int id;
    private String name;
    private String phone;

    public Patient(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        setPhone(phone);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("phone required");
        }
        this.phone = phone;
    }
    // TODO 1: add three PRIVATE fields: id (int), name (String), phone (String).
    //         Why private? Other classes must not change them directly.

    // TODO 2: add a constructor Patient(int id, String name, String phone)
    //         that stores the three values. Use `this.id = id;` style.

    // TODO 3: add getters getId(), getName(), getPhone().

    // TODO 4: add setPhone(String phone). Reject null or blank values by
    //         throwing new IllegalArgumentException("phone required").
    //         There is no setId or setName: those never change.
}
