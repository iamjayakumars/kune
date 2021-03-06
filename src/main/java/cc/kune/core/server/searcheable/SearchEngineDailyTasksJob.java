/*
 *
 * Copyright (C) 2007-2013 Licensed to the Comunes Association (CA) under
 * one or more contributor license agreements (see COPYRIGHT for details).
 * The CA licenses this file to you under the GNU Affero General Public
 * License version 3, (the "License"); you may not use this file except in
 * compliance with the License. This file is part of kune.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package cc.kune.core.server.searcheable;

import java.text.ParseException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import cc.kune.core.server.persist.KuneTransactional;

import com.google.inject.Inject;
import com.google.inject.Provider;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchEngineDailyTasksJob.
 *
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public class SearchEngineDailyTasksJob implements Job {

  /** The Constant LOG. */
  public static final Log LOG = LogFactory.getLog(SearchEngineDailyTasksJob.class);
  
  /** The search engine servlet. */
  private final Provider<SearchEngineServletFilter> searchEngineServlet;

  /**
   * Instantiates a new search engine daily tasks job.
   *
   * @param searchEngineServlet the search engine servlet
   * @throws ParseException the parse exception
   * @throws SchedulerException the scheduler exception
   */
  @Inject
  public SearchEngineDailyTasksJob(final Provider<SearchEngineServletFilter> searchEngineServlet) throws ParseException,
      SchedulerException {
    this.searchEngineServlet = searchEngineServlet;
  }

  /* (non-Javadoc)
   * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
   */
  @Override
  @KuneTransactional
  public void execute(final JobExecutionContext context) throws JobExecutionException {
    LOG.info(String.format("Daily cron job start"));
    searchEngineServlet.get().initWebClient();
    LOG.info(String.format("Daily cron job end"));
  }

}
