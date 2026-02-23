public interface IPerson {
    String getId();
    String getUserName();
    String getPassword();
    String getRole();
    boolean can(String action);
}
