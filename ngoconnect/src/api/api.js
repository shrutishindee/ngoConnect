import axios from "axios";

// Base URL for API
const API_URL = "http://localhost:8080"; // Adjust backend URL if necessary

// Login API - Using Axios for sending POST request to login
export const loginUser = async (credentials) => {
  try {
    const response = await axios.post(`${API_URL}/users/login`, credentials);
    return response.data; // Ensure response contains the `role` and other user info
  } catch (error) {
    throw new Error("Login failed");
  }
};

// Register API - Using Axios for sending POST request to register a new user
export const registerUser = async (userData) => {
  try {
    const response = await axios.post(`${API_URL}/users/register`, userData);
    return response.data; // Returning response data (e.g., the user object)
  } catch (error) {
    throw new Error("Registration failed");
  }
};

// Example of how to delete a user (for admin functionality)
export const deleteUser = async (userId) => {
  try {
    const response = await axios.delete(
      `${API_URL}/admin/users/delete/${userId}`
    );
    return response.data; // Return a success message or deleted user data
  } catch (error) {
    throw new Error("Error deleting user");
  }
};
