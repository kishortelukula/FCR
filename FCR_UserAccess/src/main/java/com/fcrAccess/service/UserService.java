package com.fcrAccess.service;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fcrAccess.entity.Users;
import com.fcrAccess.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repository;

	public String addUsers(Users users) {
		try {
			// Retrieve existing users data for the given groupName
			String usersData = getUsers(users.getGroupName());

			// Retrieve all users with the same groupName
			List<Users> dataList = getAllUsers();
			List<Users> matchGroup = dataList.stream().filter(a -> a.getGroupName().equals(users.getGroupName()))
					.collect(Collectors.toList());

			System.out.println("---------------" + usersData);
			boolean userFound = false;
			if (usersData != "" || usersData != null) {
				System.out.println("user if");
				String[] userNameArray = usersData.split(",");

				for (String a : userNameArray) {
					if (a.equals(users.getUsers())) {
						userFound = true;
						System.out.println("user if found" + userFound);
						break;
					} else {
						System.out.println("user else found" + userFound);
						
					}

				}

			}

			if ((usersData == "" || usersData == null) && matchGroup.isEmpty()) {
				// Case 1: No users exist for this group, save the new user
				repository.save(users);
				return "User Added";
			} else if (!matchGroup.isEmpty() && userFound == false) {
				// Case 2: Users exist for this group, append new users to existing data and
				// update
				String addingUser = usersData.isEmpty() ? users.getUsers() : usersData + "," + users.getUsers();
				Users existingUser = matchGroup.get(0); // Assuming there's only one matching group
				existingUser.setUsers(addingUser);
				repository.updateUsers(existingUser.getUsers(), existingUser.getGroupName());
				return "Users Added to Existing Group";
			} else {
				return "User Already excist in this group";
			}
		} catch (Exception e) {
			e.printStackTrace(); // Handle or log the exception appropriately
			return "User Add Failed, Please try again";
		}
	}

	public String getUsers(String groupName) {

		try {

			return repository.getUserFromGroup(groupName);

		} catch (Exception e) {
			// TODO: handle exception
			return "fail";
		}

	}

	public List<Users> getAllUsers() {

		try {
			return repository.findAll();

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
