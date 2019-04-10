public class Driver {

    public static void main(String[] args) {
        Friendly a = new Friendly("a");
        Unfriendly b = new Unfriendly("b");
        Healer c = new Healer("c");
        Attacker d = new Attacker("d");

        System.out.println(" ");

        a.interact(a);
        a.interact(b);
        a.interact(c);
        a.interact(d);

        System.out.println(a.getMaxHealth());
        System.out.println(b.getMaxHealth());
        System.out.println(c.getMaxHealth());
        System.out.println(d.getMaxHealth());

        System.out.println(" ");

        b.interact(b);
        b.interact(a);
        b.interact(c);
        b.interact(d);

        System.out.println(" ");

        d.interact(a);
        d.interact(b);
        d.interact(c);
        d.interact(d);

        System.out.println(" ");

        d.interact(a);
        d.interact(b);
        d.interact(d);

        c.heal(a);
        c.heal(b);
        c.heal(c);
        c.heal(d);


        // Try having attackers attack healers, other attackers,
        // themselves, etc. Refer to the homework description to see
        // what each interaction should do! (Or not do.)
    }

}