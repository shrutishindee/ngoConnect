// import React from "react";
// import { BrowserRouter as Routes, Route } from "react-router-dom";
// import Footer from "../components/Footer";
// import Home from "../components/Home";
// import AboutUs from "../components/AboutUs";
// import Projects from "../components/Projects"; // Create this component if you don't have it yet
// import GetInvolved from "../components/GetInvolved"; // Create this component if you don't have it yet
// import Login from "../components/Login";
// import Register from "../components/Register";
// import "../App.css";

// export default function HomePage() {
//   return (
//     <div className="HomePage">
//       <div className="main-content">
//         <Routes>
//           <Route path="/" element={<Home />} />
//           <Route path="/about" element={<AboutUs />} />
//           <Route path="/projects" element={<Projects />} />
//           <Route path="/get-involved" element={<GetInvolved />} />
//           <Route path="/login" element={<Login />} />
//           <Route path="/register" element={<Register />} />
//         </Routes>
//       </div>

//       <Footer />
//     </div>
//   );
// }

// src/pages/HomePage.js
import React from "react";
import Home from "../components/Home"; // Home component

const HomePage = () => {
  return (
    <div className="HomePage">
      <Home />
      {/* Other sections or components can be added here */}
    </div>
  );
};

export default HomePage;
