/*******************************************************************************
 * Copyright � 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.sqlbuilder.views.source;

import java.util.Vector;

public final class SQLCompletionProposalFactory implements SQLKeywords {

    private final static String[] fStatements = {
        "SELECT ",
        "INSERT ",
        "UPDATE ",
        "DELETE ",
        "CREATE ",
        "DROP ",
        "ALTER ",
        "GRANT ",
        "REVOKE ",
        "COMMIT",
        "ROLLBACK",
        "SET ",
        "CONNECT",
        "DISCONNECT ",
        "COMMENT ON ",        
        "TERMINATE",
        "CATALOG ",
        "UNCATALOG ",
        "WITH "
    };
    
    // number and order must be matched with fStatements. (computeContextInformation(...) in SQLCompletionProcessor.java)
    private final static String[] fContextInformation = {
        "SELECT col1, col2 FROM table1, table2 WHERE table1.col1 = table2.col2 ;",
        "INSERT INTO table_name (col1, col2) VALUES ('val1', 'val2') ;",
        "UPDATE table_name SET col1='val1' WHERE table_name.col2 = '123' ;",
        "DELETE FROM table_name WHERE table_name.col_name = '123' ;",
        "CREATE TABLE table_name (col1 VARCHAR(10) NOT NULL, col2 INTEGER) ;",
        "DROP TABLE table_name ;",
        "ALTER TABLE table_name ADD column_name INTEGER NOT NULL;",
        "GRANT SELECT [UPDATE|DELETE|...] ON table_name TO user_name ;",
        "REVOKE SELECT [UPDATE|DELETE|...] ON table_name FROM user_name;",
        "COMMIT WORK;",
        "ROLLBACK WORK ;",
        "SET CONNECTION server_name;",
        "CONNECT TO server_name;",
        "DISCONNECT server_name;",
        "COMMENT ON TABLE table_name IS 'table comment';",
        "TERMINATE;",        
        "CATALOG DATABASE database_name;",
        "UNCATALOG DATABASE database_name;",
        "WITH ... ;"
    };        
    
    private final static String[] fStatementProposals = {
        "SELECT col1, col2 FROM table1, table2 WHERE table1.col1 = table2.col2 ;",
        "INSERT INTO table_name (col1, col2) VALUES ('val1', 'val2') ;",
        "UPDATE table_name SET col1='val1' WHERE table_name.col2 = '123' ;",
        "DELETE FROM table_name WHERE table_name.col_name = '123' ;",
        "ALTER TABLE table_name ADD column_name INTEGER NOT NULL;",
        "CREATE TABLE table_name (col1 VARCHAR(10) NOT NULL, col2 INTEGER) ;",
        "CREATE VIEW view_name AS SELECT col1, col2 FROM table1 ;",
        "CREATE UNIQUE INDEX index_name ON table_name (col1, col2);",
        "CREATE SCHEMA schema_name AUTHORIZATION user_name ;",
        "CREATE DOMAIN domain_name data_type valid_values ;",
        "DROP TABLE table_name ;",
        "DROP VIEW view_name ;",
        "DROP INDEX index_name ;",
        "DROP SCHEMA schema_name ;",
        "DROP DOMAIN domain_name ;",
        "COMMIT WORK;",
        "ROLLBACK WORK ;",
        "SET CONNECTION server_name;",
        "GRANT SELECT [UPDATE|DELETE|...] ON table_name TO user_name ;",
        "REVOKE SELECT [UPDATE|DELETE|...] ON table_name FROM user_name;",
        "CONNECT TO server_name;",
        "DISCONNECT server_name;",
        "CATALOG DATABASE database_name;",
        "UNCATALOG DATABASE database_name;",
        "COMMENT ON TABLE table_name IS 'table comment';",
        "TERMINATE;",
        "WITH ... ;"
    };    

    
    private final static String[] fOperators = {
        "=",
        "<",
        ">",
        "<=",
        ">=",
        "!<",
        "!>",
        "<>",
        "!=",
        "ALL",
        "AND",
        "ANY",
        "BETWEEN",
        "EXISTS",
        "IN",
        "IS",
        "NOT",
        "NULL",
        "OR",
        "SOME"
    };

    private final static String[] fFunctions = {
        "AVG()",
        "COUNT()",
        "MAX()",
        "MIN()",
        "SUM()"
    };

    private final static String[] fClauses = { 
        "FROM ",
        "WHERE ",
        "GROUP BY ",
        "HAVING ",
        "UNION ",
        "UNION ALL ",
        "INTERSECT ",
        "INTERSECT ALL ", 
        "EXCEPT ",
        "EXCEPT ALL ",
        "ORDER BY "        
    };

    private final static String[] fDataTypes = {
        "INTEGER",
        "INT",
        "SMALLINT",
        "BIGINT",
        "REAL",
        "DOUBLE",
        "DOUBLE PRECISION",
        "FLOAT",
        "VARCHAR",
        "VARCHAR2",
        "DECIMAL",
        "DEC",
        "NUMERIC",
        "NUM",
        "NUMBER",
        "CHARACTER",
        "CHARACTER VARYING",
        "CHAR",
        "CHAR VARYING",
        "BLOB",
        "CLOB",
        "DBCLOB",
        "GRAPHIC",
        "VARGRAPHIC",
        "LONG VARCHAR",
        "LONG VARGRAPHIC",
        "LONG RAW",
           "DATE",
        "TIME",
        "TIMESTAMP",
        "DATALINK",
        "NCHAR",
        "NCHAR VARYING",
        "NVARCHAR2",
        "RAW",
        "NCLOB",
        "BFILE",
        "ROWID",
        "UROWID",
        "NATIONAL CHARACTER",
        "NATIONAL CHARACTER VARYING",
        "NATIONAL CHAR",
        "NATIONAL CHAR VARYING",
        "LONG",
        "CHARACTER LARGE OBJECT",
        "CHAR LARGE OBJECT",
        "BINARY LARGE OBJECT",
          "TINYINT",
          "SMALLMONEY",
         "MONEY",
          "SMALLDATETIME",
          "DATETIME",
          "NVARCHAR",
          "TEXT",
          "BINARY",
          "VARBINARY",
         "IMAGE",
         "BIT",
          "YEAR",
          "MEDIUMINT",
          "NATIONAL VARCHAR",
          "TINYBLOB",
          "TINYTEXT",
          "MEDIUMBLOB",
          "MEDIUMTEXT",
          "LONGBLOB",
         "LONGTEXT",
          "NTEXT",
          "BOOLEAN",
          "BYTE",
          "SHORT",
         "CURRENCY",
          "LONGVARBINARY",
          "LONGCHAR",
          "SMALLCHAR",
          "OLE",
          "SERIAL",
          "SERIAL8",
          "INT8",
          "INTERVAL",
          "LVARCHAR",
          "SMALLFLOAT",
          "NATIONAL CHARACTER LARGE OBJECT",
          "UNICODE CHARACTER",
          "UNICHAR",
          "UNIVARCHAR",
          "LONGINT",
          "LONG NVARCHAR",
          "LONG VARBINARY",
          "LONG BIT VARYING",
          "LONG BINARY"
    };

//    private final static String[] fDBObjects = {
//        "ALIAS",
//        "ASSERTION",
//        "DATABASE",
//        "DOMAIN",
//        "INDEX",
//        "PROCEDURE",
//        "SCHEMA",
//        "TABLE",
//        "TRIGGER"
//    };

    private final static String[] fConstraints = {
        "CHECK ",
        "FOREIGN KEY ",
        "PRIMARY KEY",
        "UNIQUE",
        "REFERENCES ",
        "CONSTRAINT ",
    };
    
    /**
     * Constructor.
     */
    public SQLCompletionProposalFactory() {
        super();
    }
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getAlterProposals() {
        Vector resList = new Vector();
    
        resList.add("TABLE ");
        resList.add("BUFFERPOOL ");
        resList.add("NODEGROUP ");
        resList.add("TABLESPACE ");
        resList.add("ADD ");
        resList.add("DROP ");
        resList.add("COLUMN ");
    
        for (int i = 0; i < fConstraints.length; i++) {
            resList.add(fConstraints[i]);
        }
    
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
    
        return result;
    }
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getCreateProposals() {
        Vector resList = new Vector();
        
        resList.add("TABLE ");
        resList.add("SCHEMA ");
        resList.add("PROCEDURE ");
        resList.add("FUNCTION ");
        resList.add("BUFFERPOOL ");
        resList.add("ALIAS ");
        resList.add("DISTINCT TYPE ");
        resList.add("SYNONYM ");
        resList.add("TRIGGER ");
        resList.add("VIEW ");
        resList.add("NODEGROUP ");
        resList.add("TABLESPACE ");
        resList.add("INDEX ");
        resList.add("EVENT MONITOR ");
        resList.add("DATABASE ");

        for (int i = 0; i < fDataTypes.length; i++) {
            resList.add(fDataTypes[i]);
        }
    
        for (int i = 0; i < fConstraints.length; i++) {
            resList.add(fConstraints[i]);
        }

        String[] result = new String[resList.size()];
        
        for (int i = 0; i < resList.size(); i++) {
            result[i] = (String)resList.get(i);
        }
    
        return result;
    }
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getDeleteProposals() {
        Vector resList = new Vector();
    
        resList.add("FROM ");
        resList.add("WHERE ");
    
        for (int i = 0; i < fOperators.length; i++) {
            resList.add(fOperators[i]);
        }
    
        for (int i = 0; i < fFunctions.length; i++) {
            resList.add(fFunctions[i]);
        }
                
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
        
        return result;
    }
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getDropProposals() {
        Vector resList = new Vector();
        
        resList.add("TABLE ");
        resList.add("SCHEMA ");
        resList.add("VIEW ");
        resList.add("ALIAS ");
        resList.add("BUFFERPOOL ");
        resList.add("NODEGROUP ");
        resList.add("TRIGGER ");
        resList.add("EVENT MONITOR ");
        resList.add("FUNCTION ");
        resList.add("FUNCTION MAPPING ");                
        resList.add("PROCEDURE ");
        resList.add("TABLESPACE ");
        resList.add("TABLESPACES ");
        resList.add("INDEX ");
        resList.add("INDEX EXTENSION ");        
        resList.add("DATABASE ");
    
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
    
        return result;
    }
    
    /**
     *
     * @return java.lang.String[]
     */
    public String[] getGrantProposals() {
        Vector resList = new Vector();
        
        resList.add("BINDADD ");
        resList.add("CONNECT ");
        resList.add("CREATETAB ");
        resList.add("CREATE_NOT_FENCED ");
        resList.add("IMPLICIT_SCHEMA ");
        resList.add("DBADM ");
        resList.add("LOAD ");
        resList.add("CONTROL ");
        resList.add("BIND ");
        resList.add("EXECUTE ");
        resList.add("RUN ");
        resList.add("ALTERIN ");
        resList.add("CREATEIN ");
        resList.add("DROPIN ");
        resList.add("PASSTHRU ");
        resList.add("ALL PRIVELEGES ");
        resList.add("ALTER ");
        resList.add("DELETE ");
        resList.add("INDEX ");
        resList.add("INSERT ");
        resList.add("REFERENCES ");
        resList.add("SELECT ");
        resList.add("UPDATE ");
        resList.add("ON ");
        resList.add("ON DATABASE ");
        resList.add("ON INDEX ");
        resList.add("ON PACKAGE ");
        resList.add("ON PROGRAM ");
        resList.add("ON SCHEMA ");
        resList.add("ON SERVER ");
        resList.add("ON TABLE ");
        resList.add("TO ");
        resList.add("USE OF TABLESPACE ");
        resList.add("USER ");
        resList.add("GROUP ");
        resList.add("PUBLIC ");
        resList.add("WITH GRANT OPTION"); 
        
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
        
        return result;
    }
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getInsertProposals() {
        Vector resList = new Vector();
    
        resList.add("INTO ");
        resList.add("VALUES ");
        resList.add("SELECT FROM WHERE ");
    
        for (int i = 0; i < fOperators.length; i++) {
            resList.add(fOperators[i]);
        }
                
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
    
        return result;
    }
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getRevokeProposals() {
        Vector resList = new Vector();
        
        resList.add("BINDADD ");
        resList.add("CONNECT ");
        resList.add("CREATETAB ");
        resList.add("CREATE_NOT_FENCED ");
        resList.add("IMPLICIT_SCHEMA ");
        resList.add("DBADM ");
        resList.add("LOAD ");
        resList.add("CONTROL ");
        resList.add("BIND ");
        resList.add("EXECUTE ");
        resList.add("RUN ");
        resList.add("ALTERIN ");
        resList.add("CREATEIN ");
        resList.add("DROPIN ");
        resList.add("PASSTHRU ");
        resList.add("ALL PRIVELEGES ");
        resList.add("ALTER ");
        resList.add("DELETE ");
        resList.add("INDEX ");
        resList.add("INSERT ");
        resList.add("REFERENCES ");
        resList.add("SELECT ");
        resList.add("UPDATE ");
        resList.add("ON ");
        resList.add("ON DATABASE ");
        resList.add("ON INDEX ");
        resList.add("ON PACKAGE ");
        resList.add("ON PROGRAM ");
        resList.add("ON SCHEMA ");
        resList.add("ON SERVER ");
        resList.add("ON TABLE ");
        resList.add("FROM ");
        resList.add("USE OF TABLESPACE ");
        resList.add("USER ");
        resList.add("GROUP ");
        resList.add("PUBLIC ");
    
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
        
        return result;
    }
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getSelectProposals() {
        Vector resList = new Vector();
    
        resList.add("ALL ");
        resList.add("DISTINCT ");
        resList.add("*");
        resList.add("AS ");
    
        for (int i = 0; i < fClauses.length; i++) {
            resList.add(fClauses[i]);
        }
    
        for (int i = 0; i < fOperators.length; i++) {
            resList.add(fOperators[i]);
        }
    
        for (int i = 0; i < fFunctions.length; i++){
            resList.add(fFunctions[i]);
        }
        
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
        
        return result;
    }

    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getCommitProposals() 
    {
        Vector resList = new Vector();
    
        resList.add("WORK");
        resList.add("WORK;");
        resList.add(";");
    
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
        
        return result;
    }
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getRollbackProposals() 
    {
        Vector resList = new Vector();
    
        resList.add("WORK");
        resList.add("WORK;");
        resList.add("TO SAVEPOINT");
        resList.add(";");
    
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
        
        return result;
    }    
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getSetProposals() 
    {
        Vector resList = new Vector();
    
        resList.add("CONNECTION ");
        resList.add("CURRENT ");
        resList.add("CURRENT DEFAULT TRANSFORM GROUP ");
        resList.add("DEFAULT TRANSFORM GROUP ");
        resList.add("CURRENT DEGREE ");
        resList.add("CURRENT EXPLAIN MODE ");
        resList.add("NO");
        resList.add("YES");
        resList.add("EXPLAIN ");
        resList.add("RECOMMEND INDEXS");
        resList.add("EVALUATE INDEXS");
        resList.add("CURRENT EXPLAIN SNAPSHOT ");
        resList.add("CURRENT PACKAGESET ");
        resList.add("CURRENT QUERY OPTIMIZATION ");
        resList.add("CURRENT REFRESH AGE ");
        resList.add("ANY");
        resList.add("EVENT MONITOR ");
        resList.add("STATE ");
        resList.add("PASSTHRU ");
        resList.add("RESET");
        resList.add("PATH ");
        resList.add("FUNCTION ");
        resList.add("SYSTEM PATH");
        resList.add("USER");
        resList.add("SCHEMA ");
        resList.add("SERVER OPTION ");
        resList.add("TO ");
        resList.add("FOR SERVER ");
    
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
        
        return result;
    }
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getConnectProposals() 
    {
        Vector resList = new Vector();
    
        resList.add(";");
        resList.add("TO ");
        resList.add("RESET");
        resList.add("USER ");
        resList.add("USING ");
        resList.add("NEW ");
        resList.add("CONFIRM ");
        resList.add("IN SHARE MODE");
        resList.add("IN EXCLUSIVE MODE");
        resList.add("IN EXCLUSIVE MODE ON SINGLE NODE");
    
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
        
        return result;
    }    
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getDisconnectProposals() 
    {
        Vector resList = new Vector();
    
        resList.add("ALL");
        resList.add("ALL SQL");
        resList.add("CURRENT");
    
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
        
        return result;
    }    
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getCatalogProposals() 
    {
        Vector resList = new Vector();
    
        resList.add("DATABASE ");
        resList.add("DB ");
        resList.add("AS ");
        resList.add("ON ");
        resList.add("AT NODE ");
        resList.add("WITH ");
        resList.add("AUTHENTICATION ");
        resList.add("AUTHENTICATION SERVER");
        resList.add("AUTHENTICATION CLIENT");
        resList.add("AUTHENTICATION DCS");
        resList.add("AUTHENTICATION SERVER_ENCRYPT");
        resList.add("AUTHENTICATION DCS_ENCRYPT");
        resList.add("AUTHENTICATION KERBEROS TARGET PRINCIPAL ");
        resList.add("AUTHENTICATION DCE SERVER PRINCIPAL ");
        
    
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
        
        return result;
    }    
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getUncatalogProposals() 
    {
        Vector resList = new Vector();
    
        resList.add("DATABASE ");
        resList.add("DB ");
    
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
        
        return result;
    }    
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getCommentOnProposals() 
    {
        Vector resList = new Vector();
        
        resList.add("IS ");
        resList.add("ALIAS ");
        resList.add("COLUMN ");
        resList.add("CONSTRAINT ");
        resList.add("FUNCTION ");
        resList.add("SPECIFIC FUNCTION ");
        resList.add("FUNCTION MAPPING ");
        resList.add("INDEX ");
        resList.add("NICKNAME ");
        resList.add("NODEGROUP ");
        resList.add("PACKAGE ");
        resList.add("PROCEDURE ");
        resList.add("SPECIFIC PROCEDURE ");
        resList.add("SCHEMA ");
        resList.add("SERVER ");
        resList.add("SERVER OPTION ");
        resList.add("FOR ");
        resList.add("TABLE ");
        resList.add("TABLESPACE ");
        resList.add("TRIGGER ");
        resList.add("DISTINCT ");
        resList.add("TYPE ");
        resList.add("DISTINCT TYPE ");
        resList.add("DATA ");
        resList.add("DATA TYPE ");
        resList.add("TYPE MAPPING ");
        resList.add("WRAPPER ");
        
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
    
        return result;
    }    

    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getStatementProposals() {
        return fStatements;
    }

    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getContextInformation() {
        return fContextInformation;
    }

    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getStatementTemplateProposals() {
        return fStatementProposals;
    }
    
    /**
     * 
     * @return java.lang.String[]
     */
    public String[] getUpdateProposals() {
    
        Vector resList = new Vector();
    
        resList.add("SET ");
        resList.add("WHERE ");
    
    
        for (int i = 0; i < fOperators.length; i++)
        {
            resList.add(fOperators[i]);
        }
            
        String[] result = new String[resList.size()];
        
        for (int i = 0; i<resList.size(); i++) {
            result[i] = (String)resList.elementAt(i);
        }
        
        return result;
        
    }
    
}
