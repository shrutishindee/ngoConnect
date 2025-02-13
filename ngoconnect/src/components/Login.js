// import React, { useState } from "react";

// import "../css/Login.css";

// const Login = () => {
//   const [email, setEmail] = useState("");
//   const [password, setPassword] = useState("");

//   const handleSubmit = (e) => {
//     e.preventDefault();
//     // Handle login logic here
//     console.log("Email: ", email, "Password: ", password);
//   };

//   return (
//     <div className="login-container">
//       <h2 className="login-title">Login</h2>
//       <form onSubmit={handleSubmit} className="login-form">
//         <label>Email</label>
//         <input
//           type="email"
//           placeholder="Enter your email"
//           value={email}
//           onChange={(e) => setEmail(e.target.value)}
//           required
//         />
//         <label>Password</label>
//         <input
//           type="password"
//           placeholder="Enter your password"
//           value={password}
//           onChange={(e) => setPassword(e.target.value)}
//           required
//         />
//         <button type="submit" className="login-button">
//           Login
//         </button>
//       </form>
//     </div>
//   );
// };

// export default Login;
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "../css/Login.css"; // Import your custom CSS if necessary

const LoginPage = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/users/login", {
        email,
        password,
      });

      const token = response.data.jwtToken;
      localStorage.setItem("token", token);

      const userData = {
        id: response.data.id,
        name: response.data.name,
        role: response.data.role,
      };

      localStorage.setItem("user", JSON.stringify(userData));

      if (response.data.role === "ROLE_ADMIN") {
        navigate("/admin/dashboard");
      } else if (response.data.role === "ROLE_DONOR") {
        navigate("/donor/dashboard");
      } else if (response.data.role === "ROLE_VOLUNTEER") {
        navigate("/volunteer/dashboard");
      }
    } catch (error) {
      setError("Invalid email or password");
    }
  };

  return (
    <div className="login-container">
      <h2 className="login-title">Login</h2>

      {/* Show error message if login fails */}
      {error && <div className="error-message">{error}</div>}

      <form onSubmit={handleSubmit} className="login-form">
        <label>Email</label>
        <input
          type="email"
          placeholder="Enter your email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
        <label>Password</label>
        <input
          type="password"
          placeholder="Enter your password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <button type="submit" className="login-button">
          Login
        </button>
      </form>
    </div>
  );
};

export default LoginPage;
