package com.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.entity.User;

/**
 * Description:
 * 
 * @author MarkLin
 * @Date:2019年10月31日下午3:04:50
 * @Remarks:
 */


@WebService
@Path("rscenter")
public interface IUserService {

	@POST
	@Path("/user")
	@Consumes("application/json")
	@Produces("application/json")
	public void saveUser(User user);

	@PUT
	@Path("/user")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public void updateUser(User user);

	@GET
	@Path("/user")
	@Produces("application/json")
	public List<User> findAllUsers();

	@GET
	@Path("/user/{id}")
	@Consumes("application/xml")
	@Produces("application/json")
	public User findAllById(@PathParam("id") int id);

	@DELETE
	@Path("/user/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public void deleteUser(@PathParam("id")int id);
}
