up:
	docker-compose -f ./environment/dev.yml up -d --remove-orphans

build:
	docker-compose -f ./environment/dev.yml build

down:
	docker-compose -f ./environment/dev.yml down --remove-orphans
