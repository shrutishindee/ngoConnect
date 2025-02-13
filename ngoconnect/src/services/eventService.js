import axios from "axios";

const API_URL = "http://localhost:8080/events"; // Adjust to your backend URL if different

// Get all events
export const getAllEvents = async () => {
  try {
    const response = await axios.get(API_URL); // Makes a GET request to your backend
    return response.data; // Return the list of events
  } catch (error) {
    console.error("Error fetching events", error);
    throw error; // Optionally throw an error to be handled in your component
  }
};

// Get event by ID (optional)
export const getEventById = async (eventId) => {
  try {
    const response = await axios.get(`${API_URL}/${eventId}`);
    return response.data;
  } catch (error) {
    console.error("Error fetching event by ID", error);
    throw error;
  }
};
