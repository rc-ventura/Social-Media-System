{
	"info": {
		"_postman_id": "4c4f6841-a793-4587-b652-b45422ddeb65",
		"name": "New Collection",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "23224074"
	},
	"item": [
		{
			"name": "GET: /entities//{id}",
			"item": [
				{
					"name": "http://localhost:8080/postagens/3",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/postagens/3",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"postagens",
								"3"
							]
						}
					},
					"response": []
				},
				{
					"name": "http://localhost:8080/assuntos/3",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/assuntos/3",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"assuntos",
								"3"
							]
						}
					},
					"response": []
				},
				{
					"name": "http://localhost:8080/comentarios/1",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/comentarios/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"comentarios",
								"1"
							]
						}
					},
					"response": []
				},
				{
					"name": "http://localhost:8080/editores/3",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/editores/3",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"editores",
								"3"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "GET: /entities",
			"item": [
				{
					"name": "http://localhost:8080/postagens",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/postagens",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"postagens"
							]
						}
					},
					"response": []
				},
				{
					"name": "http://localhost:8080/assuntos",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/assuntos",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"assuntos"
							]
						}
					},
					"response": []
				},
				{
					"name": "http://localhost:8080/comentarios",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/comentarios",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"comentarios"
							]
						}
					},
					"response": []
				},
				{
					"name": "http://localhost:8080/editores",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/editores",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"editores"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "POST: /entities",
			"item": [
				{
					"name": "http://localhost:8080/postagens",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \r\n    \"data\": \"2022-08-20T19:53:07Z\",\r\n    \"titulo\": \"Minha Viagem\",\r\n    \"texto\": \"Texto3\",\r\n    \"assuntos\": [],\r\n    \"comentarios\": []\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/postagens",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"postagens"
							]
						}
					},
					"response": []
				},
				{
					"name": "http://localhost:8080/assuntos",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \r\n    \"descricao\": \"#free\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/assuntos",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"assuntos"
							]
						}
					},
					"response": []
				},
				{
					"name": "http://localhost:8080/comentarios",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \r\n    \"nome\": \"@rafael100\",\r\n    \"data\": \"2022-05-18T20:30:00Z\",\r\n    \"text\": \";)\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/comentarios",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"comentarios"
							]
						}
					},
					"response": []
				},
				{
					"name": "http://localhost:8080/editores",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \r\n    \"nome\": \"Laura Bender\",\r\n    \"senha\": \"123mudar\",\r\n    \"postagens\": [\r\n        {\r\n            \"id\": 3,\r\n            \"data\": \"2022-08-20T19:53:07Z\",\r\n            \"titulo\": \"Minha Viagem\",\r\n            \"texto\": \"Texto3\",\r\n            \"assuntos\": [\r\n                {\r\n                    \"id\": 1,\r\n                    \"descricao\": \"#trip\"\r\n                },\r\n                {\r\n                    \"id\": 2,\r\n                    \"descricao\": \"#vacation\"\r\n                },\r\n                {\r\n                    \"id\": 3,\r\n                    \"descricao\": \"#freedom\"\r\n                }\r\n            ],\r\n            \"comentarios\": [\r\n                {\r\n                    \"id\": 4,\r\n                    \"nome\": \"@daniel35\",\r\n                    \"data\": \"2022-05-25T20:30:00Z\",\r\n                    \"text\": \"Amazing\"\r\n                }\r\n            ]\r\n        },\r\n        {\r\n            \"id\": 4,\r\n            \"data\": \"2022-02-20T19:53:07Z\",\r\n            \"titulo\": \"Take On Time\",\r\n            \"texto\": \"Texto4\",\r\n            \"assuntos\": [\r\n                {\r\n                    \"id\": 3,\r\n                    \"descricao\": \"#freedom\"\r\n                },\r\n                {\r\n                    \"id\": 4,\r\n                    \"descricao\": \"#healthy\"\r\n                }\r\n            ],\r\n            \"comentarios\": []\r\n        }\r\n    ]\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/editores",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"editores"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "PUT: /entities/{id}",
			"item": [
				{
					"name": "http://localhost:8080/postagens/3",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"id\": 3,\r\n    \"data\": \"2022-08-20T19:53:07Z\",\r\n    \"titulo\": \"Meu sonho\",\r\n    \"texto\": \"Texto3\",\r\n    \"assuntos\": [\r\n        {\r\n            \"id\": 1,\r\n            \"descricao\": \"#trip\"\r\n        },\r\n        {\r\n            \"id\": 2,\r\n            \"descricao\": \"#vacation\"\r\n        },\r\n        {\r\n            \"id\": 3,\r\n            \"descricao\": \"#freedom\"\r\n        }\r\n    ],\r\n    \"comentarios\": [\r\n        {\r\n            \"id\": 4,\r\n            \"nome\": \"@daniel35\",\r\n            \"data\": \"2022-05-25T20:30:00Z\",\r\n            \"text\": \"Amazing\"\r\n        }\r\n    ]\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/postagens/3",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"postagens",
								"3"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "DELETE: /entities/{id}",
			"item": [
				{
					"name": "http://localhost:8080/postagens/4",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/postagens/4",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"postagens",
								"4"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "PUT: /entities/{id}/addComentario/{id}",
			"item": [
				{
					"name": "http://localhost:8080/postagens/1/addComentario/4",
					"request": {
						"method": "PUT",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/postagens/1/addComentario/4",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"postagens",
								"1",
								"addComentario",
								"4"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "DELETE: /entities/{id}/removeComentario/{id}",
			"item": [
				{
					"name": "New Request",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				}
			]
		},
		{
			"name": "PUT: /entities/{id}/addAssunto/{id}",
			"item": [
				{
					"name": "http://localhost:8080/postagens/1/addAssunto/4",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				}
			]
		},
		{
			"name": "DELETE: /entities/{id}/removeAssunto/{id}",
			"item": [
				{
					"name": "http://localhost:8080/postagens/1/removeAssunto/2",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				}
			]
		},
		{
			"name": "PUT: /entities/{id}/addPostagem/{id}",
			"item": [
				{
					"name": "New Request",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				}
			]
		},
		{
			"name": "DELETE /entities/{id}/removePostagem/{id}",
			"item": [
				{
					"name": "New Request",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				}
			]
		}
	]
}