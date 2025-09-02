import java.util.*;
import java.sql.*;
import java.time.LocalDate;

public class Management {
    static ArrayList<Book> books = new ArrayList<>(); // useless
    static ArrayList<Member> Member = new ArrayList<>();
    static Vector<Integer> isAvailableBook = new Vector<>(); // useless
    static Vector<Integer> isAvailableMember = new Vector<>();
    static ArrayList<Borrow> whoBorrows = new ArrayList<>();

    static void addBook() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO books(bookid, title, author, genre) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter BookId: ");
            int bookid = sc.nextInt();
            sc.nextLine(); // buffer clear

            System.out.print("Enter Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            System.out.print("Enter Genre: ");
            String genre = sc.nextLine();

            ps.setInt(1, bookid);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setString(4, genre);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Book added successfully!");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean showBooks() {
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            String sql = "select title,author from books";

            ResultSet rs = stmt.executeQuery(sql);

            boolean flag = false;
            System.out.println();
            while (rs.next()) {
                if (!flag) {
                    System.out.println("Available Books\n");
                }

                String title = rs.getString("title");
                String author = rs.getString("author");

                System.out.println(title + " | " + author);
                flag = true;
            }
            con.close();
            return flag;
        }

        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // by title
    static void searchbookbytitle() {
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            String sql = "select title,author from books where title like ?";

            PreparedStatement ps = con.prepareStatement(sql);

            System.out.println();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter title : ");
            String title = sc.nextLine();

            ps.setString(1, title + "%");

            ResultSet rs = ps.executeQuery();

            boolean flag = false;
            while (rs.next()) {
                System.out.println("\nTitle: " + rs.getString("title") + ", Author: " + rs.getString("author") + "\n");
                flag = true;
            }

            if (!flag) {
                System.out.println("\nNo book found.");
            }

            rs.close();
            con.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // by author
    static void searchbookbyauthor() {
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            String sql = "select title,author from books where author like ?";

            PreparedStatement ps = con.prepareStatement(sql);

            System.out.println();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter author name : ");
            String author = sc.nextLine();

            ps.setString(1, author + "%");

            ResultSet rs = ps.executeQuery();

            boolean flag = false;
            while (rs.next()) {
                System.out.println("\nTitle: " + rs.getString("title") + ", Author: " + rs.getString("author"));
                flag = true;
            }

            if (!flag) {
                System.out.println("\nNo book found.");
            }
            System.out.println();
            rs.close();
            con.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // by genre
    static void searchbookbygenre() {
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            String sql = "select title,author from books where genre like ?";

            PreparedStatement ps = con.prepareStatement(sql);

            System.out.println();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter book's genre : ");
            String genre = sc.nextLine();

            ps.setString(1, genre + "%");

            ResultSet rs = ps.executeQuery();

            boolean flag = false;
            while (rs.next()) {
                System.out.println("\nTitle: " + rs.getString("title") + ", Author: " + rs.getString("author"));
                flag = true;
            }

            if (!flag) {
                System.out.println("\nNo book found.");
            }
            System.out.println();
            rs.close();
            con.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // by id
    static void searchbookbyid() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "select title,author from books where bookid = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            System.out.println();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Book Id : ");
            int bookid = sc.nextInt();

            ps.setInt(1, bookid);

            ResultSet rs = ps.executeQuery();

            boolean flag = false;
            while (rs.next()) {
                System.out.println("\nTitle: " + rs.getString("title") + ", Author: " + rs.getString("author"));
                flag = true;
            }

            if (!flag) {
                System.out.println("\nNo book found.");
            }
            System.out.println();
            rs.close();
            ps.close();
            con.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addMember() {
        System.out.println("\nMember Registration\n");

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO members VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Your Id: ");
            int m_id = sc.nextInt();
            sc.nextLine(); // buffer clear

            System.out.print("Enter Your Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Your Phone: ");
            long Phone = sc.nextLong();
            sc.nextLine();

            System.out.print("Enter Your Address: ");
            String address = sc.nextLine();

            ps.setInt(1, m_id);
            ps.setString(2, name);
            ps.setLong(3, Phone);
            ps.setString(4, address);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("\nMember Registration Successful..\n");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // System.out.print("Enter your id: ");

        // Scanner sc2 = new Scanner(System.in);
        // int id = sc2.nextInt();

        // for (int i : isAvailableMember) {
        // if (i == id) {
        // System.out.println("\nThe Member is already exist.\n");
        // return;
        // }
        // }

        // System.out.print("Enter your name: ");
        // Scanner sc1 = new Scanner(System.in);
        // String name = sc1.nextLine();

        // System.out.println("Member added successfully.\n");
        // Member m = new Member(name, id);
        // Member.add(m);
        // isAvailableMember.add(m.id);
    }

    static void viewMember() {
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            String sql = "select * from members";

            ResultSet rs = stmt.executeQuery(sql);

            boolean flag = false;
            System.out.println();
            while (rs.next()) {
                if (!flag) {
                    System.out.println("Available Members\n");
                }

                int id = rs.getInt("member_id");
                String name = rs.getString("name");
                long phone = rs.getLong("phone");
                String adress = rs.getString("address");

                System.out.println(id + " | " + name + " | " + phone + " | " + adress);
                flag = true;
            }
            con.close();
            if (!flag)
                System.out.println("No Member Available...");
            else
                System.out.println();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void borrowbook() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO borrow(bookid, member_id, borrow_date,return_date ) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter BookId: ");
            int bookid = sc.nextInt();

            System.out.print("Enter Member-Id: ");
            int member_id = sc.nextInt();

            LocalDate today = LocalDate.now();
            LocalDate returndate = today.plusDays(7);

            ps.setInt(1, bookid);
            ps.setInt(2, member_id);
            ps.setDate(3, java.sql.Date.valueOf(today));
            ps.setDate(4, java.sql.Date.valueOf(returndate));

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Borrow Book Successful...");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void returnBook() {
        try {
            System.out.println("\nReturning Book\n");
            Connection con = DBConnection.getConnection();
            String sql = "delete from borrow where member_id = ? and bookid = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Member-Id: ");
            int member_id = sc.nextInt();
            System.out.print("Enter Book-Id: ");
            int book_id = sc.nextInt();
            ps.setInt(1, member_id);
            ps.setInt(2, book_id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Return book successful\n");
            } else {
                System.out.println("No book found for this Member-Id\n");
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void viewBorrowedBook() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "select * from borrow where Member_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            System.out.println();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Member Id : ");
            int memberid = sc.nextInt();

            ps.setInt(1, memberid);

            ResultSet rs = ps.executeQuery();

            boolean flag = false;
            while (rs.next()) {
                System.out.println("\nBookID: " + rs.getInt("bookid") + "\nMemberID: " + rs.getInt("member_id")
                        + "\nBorrow Date: " + rs.getDate("borrow_date") + "\nReturn Date: "
                        + rs.getDate("return_date"));
                flag = true;
            }

            if (!flag) {
                System.out.println("\nNo book borrowed.");
            }
            System.out.println();
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteBook() {
        Scanner sc = null;
        try {
            System.out.println("\nDeleting Book\n");
            Connection con = DBConnection.getConnection();
            String sql = "delete from books where bookid = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            sc = new Scanner(System.in);
            System.out.print("Enter Book-Id: ");
            int book_id = sc.nextInt();
            ps.setInt(1, book_id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("\nDeleting book successful\n");
            } else {
                System.out.println("\nDeleting book unsuccessful\n");
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteMem() {
        Scanner sc = null; // Scanner-কে try ব্লকের বাইরে ডিক্লেয়ার করুন
        try {
            System.out.println("\nDeleting Member\n");
            Connection con = DBConnection.getConnection();
            String sql = "delete from members where member_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            sc = new Scanner(System.in);
            System.out.print("Enter Member-Id: ");
            int member_id = sc.nextInt();
            ps.setInt(1, member_id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("\nCanceling membership successful\n");
            } else {
                System.out.println("\nCanceling membership unsuccessful\n");
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}