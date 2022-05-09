import axios from 'axios';

const instance = axios.create({
	baseURL: 'http://localhost:8080/api/v1',
	timeout: 9000
});

instance.interceptors.request.use(
	(config) => {
		return config
	},
	(error) => {
		Promise.reject(error)
	}
)

instance.interceptors.response.use(
	(response) => {
		const res = response.data
		if (res.code !== 200) {
			Message({
				message: res.message || 'Error',
				type: 'error',
				duration: 5 * 1000
			})
			return Promise.reject(new Error(res.message || 'Error'))
		} else {
			return response.data
		}
	},
	(error) => {
		Message({
			message: error.message,
			type: 'error',
			duration: 5 * 1000
		})
		return Promise.reject(error)
	}
)

export default instance;
