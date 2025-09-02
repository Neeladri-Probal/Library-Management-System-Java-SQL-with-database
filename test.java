import java.util.Scanner;
// javac -cp ".;lib/mysql-connector-j-9.4.0.jar" DBConnection.java test.java
// java -cp ".;lib/mysql-connector-j-9.4.0.jar" test

public class test {
    public static void main(String[] args) {
        System.out.println(
                "===================================\n    Welcome to Leading Library\n===================================");
        System.out.println("\n1. Log in as user");
        System.out.println("2. Log in as librarian");
        System.out.println("3. Exit\n");
        System.out.print("Enter your choice : ");
        Scanner usr = new Scanner(System.in);
        int chs = usr.nextInt();
        if (chs == 1) {
            System.out.println("\nUser Home");
            System.out.println("\n1.View books"); // D
            System.out.println("2.Search book"); // D
            System.out.println("3.Take membership"); // D
            System.out.println("4.View Borrowed book"); // D
            System.out.println("5.Cancel Membership"); // D
            System.out.println("6.Exit\n");
            while (true) {
                System.out.println("User Home\n");
                System.out.print("Enter your choice : ");
                Scanner ch = new Scanner(System.in);
                int choic = ch.nextInt();
                if (choic == 1) {
                    if (!Management.showBooks()) {
                        System.out.println("No book available.\n");
                    }
                } else if (choic == 2) {
                    System.out.println("\n1.Search by Title");
                    System.out.println("2.Search by Author");
                    System.out.println("3.Search by Genre");
                    System.out.print("4.Search by BookId\n\nChoose Option: ");

                    Scanner scn = new Scanner(System.in);
                    int ch1 = scn.nextInt();

                    if (ch1 == 1) {
                        Management.searchbookbytitle();
                    } else if (ch1 == 2) {
                        Management.searchbookbyauthor();
                    } else if (ch1 == 3) {
                        System.out.println("\n1.Novel");
                        System.out.println("2.Science Fiction");
                        System.out.println("3.Detective");
                        System.out.println("4.Essay");
                        System.out.println("5.Fantasy");
                        Management.searchbookbygenre();
                    } else if (ch1 == 4) {
                        Management.searchbookbyid();
                    }
                } else if (choic == 3) {
                    Management.addMember();
                } else if (choic == 4) {
                    System.out.println("\nViewing Borrowed Book");
                    Management.viewBorrowedBook();
                } else if (choic == 5) {
                    Management.deleteMem();
                } else if (choic == 6) {
                    System.out.println("\nThanks for visiting...");
                    System.exit(0);
                }
            }
        } else if (chs == 3) {
            System.out.println("\nThanks for visiting...");
            System.exit(0);
        } else if (chs == 2) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nLibrarian Home\n");
            System.out.println("\n1.Add book"); // D
            System.out.println("2.View books"); // D
            System.out.println("3.Search book"); // D
            System.out.println("4.Add member"); // D
            System.out.println("5.View Member"); // D
            System.out.println("6.Borrow book"); // D
            System.out.println("7.Return book"); // D
            System.out.println("8.View Borrowed book"); // D
            System.out.println("9.Delete Book"); // D
            System.out.println("10.Delete Member"); // D
            System.out.println("11.Exit\n");
            while (true) {
                System.out.println("Librarian Home\n");
                System.out.print("Choose option: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1: {
                        Management.addBook();
                        break;
                    }
                    case 2: {
                        if (!Management.showBooks()) {
                            System.out.println("No book available.\n");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("\n1.Search by Title");
                        System.out.println("2.Search by Author");
                        System.out.println("3.Search by Genre");
                        System.out.print("4.Search by BookId\n\nChoose Option: ");

                        Scanner scn = new Scanner(System.in);
                        int ch = scn.nextInt();

                        if (ch == 1) {
                            Management.searchbookbytitle();
                        } else if (ch == 2) {
                            Management.searchbookbyauthor();
                        } else if (ch == 3) {
                            System.out.println("\n1.Novel");
                            System.out.println("2.Science Fiction");
                            System.out.println("3.Detective");
                            System.out.println("4.Essay");
                            System.out.println("5.Fantasy");
                            Management.searchbookbygenre();
                        } else if (ch == 4) {
                            Management.searchbookbyid();
                        }
                        break;
                    }
                    case 4: {
                        Management.addMember();
                        break;
                    }
                    case 5: {
                        Management.viewMember();
                        break;
                    }
                    case 6: {
                        Management.borrowbook();
                        break;
                    }
                    case 7: {
                        Management.returnBook();
                        break;
                    }
                    case 8: {
                        System.out.println("\nViewing Borrowed book");
                        Management.viewBorrowedBook();
                        break;
                    }
                    case 9: {
                        Management.deleteBook();
                        break;
                    }
                    case 10: {
                        Management.deleteMem();
                        break;
                    }
                    case 11: {
                        System.out.println("Thanks for visiting...");
                        return;
                    }
                }
            }
        }
    }
}