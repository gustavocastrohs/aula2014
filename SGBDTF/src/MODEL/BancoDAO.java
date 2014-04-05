
package MODEL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author
 */
public class BancoDAO implements CONTROL.IBancoDAO{
    // Inicialização e conexão com o Banco Oracle
    private static String driverName; // = "oracle.jdbc.driver.OracleDriver";
    private static String url       ; // = "jdbc:oracle:thin:@" + server + ":" + porta + ":" + sid;
    
    // Dados do Servidor
    private static String server; // = "camburi.pucrs.br";
    private static String porta; // = "1521";
    private static String sid       ; // = "facin11g";
    private static String username  ; // = "login";
    private static String password  ; // = "senha";
    private static BancoDAO instancia;
    
    // CONSTRUTOR //
    
      public static BancoDAO getInstance(
             String username,
            String password,
            String porta
      ) throws BancoDAOExcepiton {
          if (instancia == null) {
              instancia = new BancoDAO(username,password,porta);
            
          }
        return instancia;
      }
    
    
    private BancoDAO(
            String username,
            String password,
            String porta
    
    ) throws BancoDAOExcepiton{
        driverName = "oracle.jdbc.driver.OracleDriver";
        url        = "jdbc:oracle:thin:@";
        this.username = username;
        this.password= password;
        this.porta = porta;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {
            throw new BancoDAOExcepiton("JdbcOdbDriver not found!!");
        }
        boolean verificaSeExisteATabela = verificaSeExisteATabela();
        if (verificaSeExisteATabela){
        //cria instancia de tableas;
        }
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    
    
    
        private static Connection getConnection() throws SQLException {
            url=url + server + ":" + porta + ":" + sid;
            return DriverManager.getConnection(url, username, password);
    }

    
    
    private boolean verificaSeExisteATabela() {

        String sql = "select s.schemaname || '.' || t.tablename "
                + "     from sys.systables t, sys.sysschemas s "
                + "     where t.schemaid = s.schemaid"
                + "          and t.tabletype = 'T'"
                + "     order by s.schemaname, t.tablename";

        String resultado = "";
        try {

            try (Connection con = getConnection()) {
                Statement sta = con.createStatement();
                ResultSet res = sta.executeQuery(sql);
                while (res.next()) {
                    resultado = res.getString(1);
                }
                res.close();
                sta.close();
            }
            return !"".equals(resultado);
        } catch (SQLException ex) {
            return false;
        }

    }
}