package com.socialmedia.alternativeevents.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.alternativeevents.entities.Permission;
import com.socialmedia.alternativeevents.entities.Role;
import com.socialmedia.alternativeevents.entities.RolePermissionSet;
import com.socialmedia.alternativeevents.service.PermissionService;
import com.socialmedia.alternativeevents.service.RolePermissionSetService;
import com.socialmedia.alternativeevents.service.RoleService;

@RestController
@RequestMapping("/alternativeevents/api")
public class RoleController {
	
	private RoleService roleService;
	
	private PermissionService permissionService; 
	
	private RolePermissionSetService rolePermissionSetService; 
	
	@Autowired
	public RoleController(RoleService theRoleService, PermissionService thePermissionService, RolePermissionSetService theRolePermissionSetService){
		roleService = theRoleService;
		permissionService = thePermissionService;
		rolePermissionSetService = theRolePermissionSetService;
	}
	
	@GetMapping("/roles")
	public List<Role> getRoles() {
		return roleService.findAll();
	}
	
	@GetMapping("/roles/{roleId}")
	public Role getRole(@PathVariable BigInteger roleId) {
		
		Role theRole = roleService.findById(roleId);
		
		if (theRole == null)
			throw new RuntimeException("Role did not found - " + roleId);
		
		return theRole;
	}
	
	@PostMapping("/roles")
	public Role addRole(@RequestBody Role theRole) {
		theRole.setId(BigInteger.valueOf(0));
		
		roleService.save(theRole);
		
		return theRole;
	}
	
	@PutMapping("/roles/{roleId}")
	public Role updateRole(@RequestBody Role theRole, @PathVariable BigInteger roleId) {
		
		theRole.setId((BigInteger)roleId);
		
		roleService.save(theRole);
		
		return theRole;
	}
	
	@DeleteMapping("/roles/{roleId}")
	public Role deleteRole(@PathVariable BigInteger roleId) {
		
		Role theRole = roleService.findById(roleId);
		
		roleService.delete(roleId);
		
		return theRole;
	}
	
	
	@GetMapping("/permissions")
	public List<Permission> getPermissions() {
		return permissionService.findAll();
	}
	
	@GetMapping("/permissions/{permissionId}")
	public Permission getPermission(@PathVariable BigInteger permissionId) {
		Permission thePermission = permissionService.findById(permissionId);
		
		if (thePermission == null)
			throw new RuntimeException("Permission did not found - " + permissionId);
		return thePermission;
	}
	
	@PostMapping("/permissions")
	public Permission addPermission(@RequestBody Permission thePermission) {
		
		// also just in case they pass an id JSON ... set id to 0
		
		thePermission.setId(BigInteger.valueOf(0));
		
		permissionService.save(thePermission);
		
		return thePermission;
	}
	
	@PutMapping("/permissions/{permissionId}")
	public Permission updatePermission(@RequestBody Permission thePermission, @PathVariable BigInteger permissionId){
		
		thePermission.setId((BigInteger) permissionId);
		
		permissionService.save(thePermission);
		
		return thePermission;
		
	}
	
	@DeleteMapping("/permissions/{permissionId}")
	public Permission deletePermission(@PathVariable BigInteger permissionId) {
		
		Permission permission = permissionService.findById(permissionId);
		
		permissionService.delete(permissionId);
		
		return permission;
	}
	
	@GetMapping("/rolepermissionsets")
	public List<RolePermissionSet> getRolePermissionSets(){
		return rolePermissionSetService.findAll();
	}
	
	@GetMapping("/rolepermissionsets/{rolePermissionSetId}/role")
	public Role getRolePermissionSetRole(@PathVariable BigInteger rolePermissionSetId){
		return rolePermissionSetService.getRolePermissionSetRole(rolePermissionSetId);
	}
	
	@GetMapping("/rolepermissionsets/{rolePermissionSetId}/permission")
	public Permission getRolePermissionSetPermission(@PathVariable BigInteger rolePermissionSetId){
		return rolePermissionSetService.getRolePermissionSetPermission(rolePermissionSetId);
	}
}
