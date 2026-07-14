import axios from "axios";

const api=axios.create({
    url:"http://localhost:8080"
});

export default api;


