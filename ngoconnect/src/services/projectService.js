import axios from "axios";

const API_URL = "http://localhost:8080/projects"; // Update if your backend is running on a different port

// Get all projects
export const getAllProjects = async () => {
  try {
    const response = await axios.get(API_URL); // Makes a GET request to your backend
    return response.data; // Return the list of projects
  } catch (error) {
    console.error("Error fetching projects", error);
    throw error; // Optionally throw an error to be handled in your component
  }
};

// Get project by ID (optional)
export const getProjectById = async (projectId) => {
  try {
    const response = await axios.get(`${API_URL}/${projectId}`);
    return response.data;
  } catch (error) {
    console.error("Error fetching project by ID", error);
    throw error;
  }
};
