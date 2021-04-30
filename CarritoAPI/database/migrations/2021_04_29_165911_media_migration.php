<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class MediaMigration extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('media', function (Blueprint $table) {
            $table->increments('id');
            $table->string('name');//el nombre del archivo
            $table->string('type');//Si es Imagen Video ETC
            $table->integer('id_product')->unsigned();//de qué producto es

            $table->timestamps();

            //Relaciones
            $table->foreign('id_product')->references('id')->on('products');
         
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('media');
    }
}
