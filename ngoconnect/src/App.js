// src/App.js
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom"; // Import BrowserRouter here
import HomePage from "./pages/HomePage"; // Ensure your HomePage component is imported
import AboutUs from "./components/AboutUs";
import GetInvolved from "./components/GetInvolved";
import Login from "./components/Login";
import Register from "./components/Register";
import ProjectList from "./components/ProjectList";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import EventList from "./components/EventList";
import AdminDashboard from "./components/AdminDashboard";
import DonorDashboard from "./components/DonorDashboard";
import VolunteerDashboard from "./components/VolunteerDashboard";

const App = () => {
  return (
    <BrowserRouter>
      <Navbar />
      <div className="main-content">
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/about" element={<AboutUs />} />
          <Route path="/projects" element={<ProjectList />} />
          <Route path="/events" element={<EventList />} />{" "}
          <Route path="/get-involved" element={<GetInvolved />} />
          <Route path="/admin/dashboard" element={<AdminDashboard />} />
          <Route path="/donor/dashboard" element={<DonorDashboard />} />
          <Route path="/volunteer/dashboard" element={<VolunteerDashboard />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/logout" element={<HomePage />} />
        </Routes>
      </div>
      <Footer />
    </BrowserRouter>
  );
};

export default App;
