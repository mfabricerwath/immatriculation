package com.inss.immatriculation.pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "audit_rec")
public class AuditRec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Suppose que vous avez un ID auto-généré
    private Long id;

    @Column(name = "table_name", length = 30)
    private String tableName;

    @Column(name = "column_name", length = 30)
    private String columnName;

    @Column(name = "row_id", length = 50)
    private String rowId; // Oracle ROWID

    @Column(name = "old_value", length = 500)
    private String oldValue;

    @Column(name = "new_value", length = 500)
    private String newValue;

    @Column(name = "user_name", length = 50)
    private String userName;

    @Column(name = "date_modified")
    private LocalDateTime dateModified;

    @Column(name = "action_flag", length = 1)
    private String actionFlag; // 'M' pour UPDATE, 'S' pour DELETE

    @Column(name = "sql_txt", length = 2000)
    private String sqlTxt;

    @Column(name = "terminal", length = 100)
    private String terminal;

    @Column(name = "module", length = 100)
    private String module;

    @Column(name = "apps_username", length = 50)
    private String appsUsername;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getDateModified() {
		return dateModified;
	}

	public void setDateModified(LocalDateTime dateModified) {
		this.dateModified = dateModified;
	}

	public String getActionFlag() {
		return actionFlag;
	}

	public void setActionFlag(String actionFlag) {
		this.actionFlag = actionFlag;
	}

	public String getSqlTxt() {
		return sqlTxt;
	}

	public void setSqlTxt(String sqlTxt) {
		this.sqlTxt = sqlTxt;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getAppsUsername() {
		return appsUsername;
	}

	public void setAppsUsername(String appsUsername) {
		this.appsUsername = appsUsername;
	}
    
    
    
    
}