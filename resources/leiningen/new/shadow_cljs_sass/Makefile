.PHONY:css
css:
	npx sass --watch sass/main.scss:public/css/main.css

.PHONY:shadow
shadow:
	npx shadow-cljs watch frontend

.PHONY:dev-tasks
dev-tasks: css shadow
	echo "finished"

.PHONY:dev
dev:
	${MAKE} -j 2 dev-tasks 
