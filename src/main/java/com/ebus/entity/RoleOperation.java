package com.ebus.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="product.cl_role_operations")
public class RoleOperation {
	@Id
    private RoleOperationId roleOperationId;
	public RoleOperationId getRoleOperationId() {
		return roleOperationId;
	}
	public void setRoleOperationId(RoleOperationId roleOperationId) {
		this.roleOperationId = roleOperationId;
	}
	@Embeddable
    public static class RoleOperationId implements Serializable {
		@Column(name="role_id")
	    private String roleId;
		@Column(name="operation_id")
	    private String operationId;
		public String getRoleId() {
			return roleId;
		}
		public void setRoleId(String roleId) {
			this.roleId = roleId;
		}
		public String getOperationId() {
			return operationId;
		}
		public void setOperationId(String operationId) {
			this.operationId = operationId;
		}

    }
	
	

}


