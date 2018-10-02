 	            //method 1
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(i+"");
                        }
                    });

                    //method 2
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv2.setText(i+"");
                        }
                    });

                    //method 3
                    mhander.sendEmptyMessage(0);